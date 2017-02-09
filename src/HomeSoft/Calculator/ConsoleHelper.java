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

    public static void printLine(String value){
        System.out.println(value);
    }

    public static void printLines(ArrayList<String> list){
        for (String s: list){
            System.out.println(s);
        }
    }

    public static String readLine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String inputText = "";
        try {
            inputText = br.readLine();
            br.close();
        }
        catch(IOException ex) {
            //do nothing
        }
        return inputText;
    }

    public static ArrayList<String> readAll() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        ArrayList<String> inputList = new ArrayList<String>();
        while(br.ready()){
            try {
                inputList.add(br.readLine());
            }
            catch(IOException ex) {
                //do nothing
            }
        }
        return inputList;
    }


}
