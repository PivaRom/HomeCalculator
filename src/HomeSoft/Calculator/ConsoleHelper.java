package HomeSoft.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.System.in;

/**
 * Created by red7 on 2/7/2017.
 */
public class ConsoleHelper {

    public void clear()
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
            System.out.println("[clear console] " + ex.getMessage());
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

    public void printResultError(String message){
        this.printLine("[ERROR]: " + message);
    }

    public void printLines(List<String> list, String prefix, String suffix){
        for (String s: list){
            System.out.println(prefix + s + suffix);
        }
    }


    public String readLine(){
        String inputText = "";

        try {
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            inputText = br.readLine();
            if(isr.ready()){
                isr.close();
            }
            if(br.ready()){
                br.close();
            }
        }
        catch(IOException ex) {
            this.printResultError("Can not read console! " + ex.getMessage());
        }

        return inputText;
    }

    public ArrayList<String> readAll() {
        ArrayList<String> inputList = new ArrayList<String>();
        try {
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            while (br.ready()) {
                inputList.add(br.readLine());
            }
            if(isr.ready()){
                isr.close();
            }
            if(br.ready()){
                br.close();
            }

        }
        catch(IOException ex) {
            this.printResultError("Can not read multiline console! " + ex.getMessage());
        }
        return inputList;
    }

    public String inputString(String meassage){
        String text = "";
        if(!meassage.isEmpty()) {
            this.printLine(meassage);
        }
        text = this.readLine();
        return text;
    }

    public Integer inputInteger(String meassage) {
        String text = "";
        Integer result = 0;
        if(!meassage.isEmpty()) {
            this.printLine(meassage);
        }
        try {
            result = Integer.parseInt(text);
        }
        catch(NumberFormatException ex) {
            this.printResultError("Can not convert string '" + text + "' to integer. " + ex.getMessage());
        }
        return result;
    }

    public Double inputDouble(String meassage){
        String text = "";
        Double result = 0.0D;
        text = this.inputString(meassage);
        if(!meassage.isEmpty()) {
            this.printLine(meassage);
        }
        try {
            result = Double.parseDouble(text);
        }
        catch(NumberFormatException ex) {
            this.printResultError("Can not convert string " + text + " to double. " + ex.getMessage());
        }
        return result;
    }


    public Date inputDate(String meassage) throws IOException{
        String text = "";
        Date result = null;
        text = this.inputString(meassage);
        DateFormat df = new SimpleDateFormat("dd.MM.YYYY HH24.MI.SS");
        if(!meassage.isEmpty()) {
            this.printLine(meassage);
        }
        try {
            result =  df.parse(text);
        }
        catch(ParseException ex) {
            this.printResultError("Can not convert string " + text + " to date. Expect string format '" + "dd.MM.YYYY hh.mi.ss" + "'. " + ex.getMessage());
        }
        return result;
    }


}
