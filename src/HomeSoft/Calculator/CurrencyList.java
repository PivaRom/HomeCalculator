package HomeSoft.Calculator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by RiP on 04.02.2017.
 */
public class CurrencyList extends ArrayList<Currency> implements ConsolePrintable, FileStorable, Listable {
    public CurrencyList(int initialCapacity) {
        super(initialCapacity);
    }

    public CurrencyList() {
    }

    public CurrencyList(Collection<? extends Currency> c) {
        super(c);
    }

    @Override
    public String toString() {
        String result ="";
        result  += "CurrencyList" + "\n";
        result  += "{" + "\n";
        for (Currency c:this) {
            result += c.toString() + "\n";
        }
        result  += "}" + "\n";

        return result;
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder("");
        String s =  GlobalParameter.FILE_LINE_SEPARATOR;
        for (Currency c : this) {
            sb.append(c.toFile() + s);
        }
        return sb.toString();
    }

    public void readFile(String fileName) {
        File f = new File(fileName);
        String line = "";
        Currency currency = new Currency();
        Boolean firstLine = true;
        if(f.exists()){
            this.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                try{
                    while ((line = br.readLine()) != null) {
                        if(!firstLine){
                            currency = new Currency();
                            currency.parseLine(line);
                            this.add(currency);
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
            writer.println("id;code;name");
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

    public Currency getByKey(String key){
        Currency result = new Currency();
        for (Currency c:this){
            if(key.equals(c.getCode())){
                result = c;
                break;
            }
        }
        return result;
    }

}
