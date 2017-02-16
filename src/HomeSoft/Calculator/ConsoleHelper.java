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

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception ex) {
            //  Handle any exceptions.
        }
    }

    public void printLine(String value){
        System.out.println(value);
    }

    public void printString(String value){
        System.out.print(value);
    }

    public void printResultOk(){
        this.printLine("[OK]");
    }

    public void printResultError(){
        this.printLine("[ERROR]");
    }

    public void printLines(ArrayList<String> list){
        for (String s: list){
            System.out.println(s);
        }
    }

    public String readLine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String inputText = "";
        br = new BufferedReader(new InputStreamReader(in));
        br.reset();
        try {
            inputText = br.readLine();
        }
        catch(IOException ex) {
            throw new IOException("Can not read console! " + ex.getMessage());
        }
        finally{
            br.close();
        }
        return inputText;
    }

    public String inputString(String meassage) throws IOException{
        String text = "";
        this.printLine(meassage);
        text = this.readLine();
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
            new NumberFormatException("Can not convert string " + text + " to integer." + ex.getMessage());
        }
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
            new NumberFormatException("Can not convert string " + text + " to double.");
        }
        return result;
    }

    public ArrayList<String> readAll() {
        ArrayList<String> inputList = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        try {
            while (br.ready()) {
                inputList.add(br.readLine());
            }
        }
        catch(IOException ex) {
            new Exception("Can not read console!!!"+ ex.getMessage());
        }

        //br.close();

        return inputList;
    }

}
