package HomeSoft.Calculator;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by red7 on 2/8/2017.
 */
public class OperationList extends ArrayList<Operation> implements ConsolePrintable {
    public OperationList() {
    }

    @Override
    public String toString() {
        String result ="";
        result  += "AccountList" + "\n";
        result  += "{" + "\n";
        for (Operation o : this) {
            result += o.toString() + "\n";
        }
        result  += "}" + "\n";

        return result;
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder("");
        String s =  GlobalParameter.FILE_LINE_SEPARATOR;
        for (Operation o : this) {
            sb.append(o.toFile() + s);
        }
        return sb.toString();
    }

    public void readFile(String fileName, CurrencyList cList, AccountList aList, ItemList iList ) {
        File f = new File(fileName);
        String line = "";
        Operation oper = new Operation();
        Boolean firstLine = true;
        if(f.exists()){
            this.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                try{
                    while ((line = br.readLine()) != null) {
                        if(!firstLine){
                            oper = new Operation();
                            oper.parseLine(line,cList,aList,iList);
                            this.add(oper);
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

    public Operation getByKey(Integer key){
        Operation result = new Operation();
        for (Operation o:this){
            if(key.equals(o.getId())){
                result = o;
                break;
            }
        }
        return result;
    }

}
