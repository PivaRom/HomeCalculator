package HomeSoft.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.System.in;

/**
 * Created by red7 on 2/7/2017.
 */
public class ConsoleHelper {

    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    public void printLine(String value){
        System.out.println(value);
    }

    public void printLines(ArrayList<String> list){
        for (String s: list){
            System.out.println(s);
        }
    }

    public String readLine() throws IOException {
        String inputText = "";
        try {
            inputText = br.readLine();
        }
        catch(IOException ex) {
            throw new IOException("Can not read console! " + ex.getMessage());
        }
        finally{
            //br.close();
        }
        return inputText;
    }

    public String inputString(String meassage) throws IOException{
        String text = "";
        this.printLine(meassage);
        text = this.readLine();
        this.printLine("OK");
        return text;
    }

    public Integer inputInteger(String meassage) throws IOException{
        String text = "";
        Integer result = 0;
        text = this.inputString(meassage);
        try {
            result = Integer.parseInt(text);
        }
        catch(Exception ex) {
            new NumberFormatException("Cannot convert string " + text + " to integer." + ex.getMessage());
        }
        this.printLine("OK");
        return result;
    }

    public Double inputDouble(String meassage) throws IOException{
        String text = "";
        Double result = 0.0D;
        text = this.inputString(meassage);
        try {
            result = Double.parseDouble(text);
        }
        catch(Exception ex) {
            new NumberFormatException("Cannot convert string " + text + " to double.");
        }
        this.printLine("OK");
        return result;
    }

    public void streamClose(){
        try{
            this.br.close();
        }catch(Exception ex) {
            //nothing
        }
    }

    public ArrayList<String> readAll() {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        ArrayList<String> inputList = new ArrayList<String>();
        try {
            while (br.ready()) {
                inputList.add(br.readLine());
            }
        }catch(IOException ex) {
            new Exception("Can not read console!!!");
        }
        return inputList;
    }


}
