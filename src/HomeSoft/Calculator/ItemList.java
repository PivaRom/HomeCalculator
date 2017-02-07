package HomeSoft.Calculator;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by red7 on 2/7/2017.
 */
public class ItemList extends ArrayList<Item> implements ConsolePrintable, FileStorable {

    public ItemList() {
    }

    @Override
    public String toString() {
        String result ="";
        result  += "ItemList" + "\n";
        result  += "{" + "\n";
        for (Item i:this) {
            result += i.toString() + "\n";
        }
        result  += "}" + "\n";

        return result;
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder("");
        String s =  GlobalParameter.FILE_LINE_SEPARATOR;
        for (Item i : this) {
            sb.append(i.toFile() + s);
        }
        return sb.toString();
    }

    public void readFile(String fileName) {
        File f = new File(fileName);
        String line = "";
        Item item = new Item();
        Boolean firstLine = true;
        if(f.exists()){
            this.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                try{
                    while ((line = br.readLine()) != null) {
                        if(!firstLine){
                            item = new Item();
                            item.parseLine(line);
                            this.add(item);
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
            writer.println("id;pid;code;type");
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


    @Override
    public void print() {
        System.out.print(this.toString());
    }

    @Override
    public void println() {
        System.out.println(this.toString());
    }

}
