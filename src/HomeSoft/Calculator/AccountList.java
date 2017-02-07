package HomeSoft.Calculator;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by red7 on 2/7/2017.
 */
public class AccountList  extends ArrayList<Account> implements ConsolePrintable, FileStorable {
    public AccountList() {
    }

    @Override
    public String toString() {
        String result ="";
        result  += "AccountList" + "\n";
        result  += "{" + "\n";
        for (Account a:this) {
            result += a.toString() + "\n";
        }
        result  += "}" + "\n";

        return result;
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder("");
        String s =  GlobalParameter.FILE_LINE_SEPARATOR;
        for (Account a : this) {
            sb.append(a.toFile() + s);
        }
        return sb.toString();
    }

    public void readFile(String fileName) {
        File f = new File(fileName);
        String line = "";
        Account account = new Account();
        Boolean firstLine = true;
        if(f.exists()){
            this.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                try{
                    while ((line = br.readLine()) != null) {
                        if(!firstLine){
                            account = new Account();
                            account.parseLine(line);
                            this.add(account);
                        }
                        if(firstLine){
                            firstLine = false;
                        }
                    }
                }
                catch(IOException ex){}
            }
            catch (IOException ex){}
        }
    }

    public void writeFile(String fileName) {
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println("id;code;name;type");
            writer.write(this.toFile());
            writer.close();
        } catch (IOException e) {}
    }

    public boolean existFile(String fileName) {
        File f = new File(fileName);
        return f.exists();
    }

    public boolean validateFile(String fileName) {
        return false;
    }

    public void print() {
        System.out.print(this.toString());
    }

    public void println() {
        System.out.println(this.toString());
    }



}
