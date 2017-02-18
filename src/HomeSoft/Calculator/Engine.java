package HomeSoft.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * Created by RiP on 15.02.2017.
 */
public class Engine {

    public static void main(String[] arg){
        run();
    }

    public static void run()  {
        boolean canExit = false;
        System.out.println("Hellow User! What would you like?");
        String cmd = "";
        AccountList aList = new AccountList();
        aList.readFile("production//HomeCalculator//HomeSoft//Calculator/Account.txt");

        while ( canExit != true){
            try {
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                cmd = br.readLine();
                if (br.ready()){
                    br.close();
                    System.out.println("1");

                }
                if (isr.ready()){
                    System.out.println("2");

                    isr.close();
                }
            }
            catch(IOException ex){
                System.out.println("!"+ex.getMessage());
            }
            if (executeCommand(cmd, aList) == 1){
                System.out.println("[OK]");
            }
            cmd="";
        }
    }

    public static int executeCommand(String cmd, AccountList aList){
        UI ui = new UI();
        int result = 0;
        if(cmd.toUpperCase().equals("EXIT")){
            System.out.println("By by...");
            System.exit(1);
            result = 1;
        }
        else if(cmd.toUpperCase().equals("ADD ACCOUNT")){
            aList.add(ui.createAccount(aList.size()));
            result = 1;
        }
        else{
            System.out.println("Command '"+cmd+"' is incorrect! Pleas type correct command.");
        }

        return result;
    }


}
