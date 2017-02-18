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
        CurrencyList cList = new CurrencyList();
        ItemList iList = new ItemList();

        String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);

        aList.readFile(dir + "/out/production//HomeCalculator//HomeSoft//Calculator/Account.txt");
        cList.readFile(dir + "/out/production//HomeCalculator//HomeSoft//Calculator/Currency.txt");
        iList.readFile(dir + "/out/production//HomeCalculator//HomeSoft//Calculator/Item.txt");

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
            if (executeCommand(cmd, aList, cList, iList) == 1){
                System.out.println("[OK]");
            }
            cmd="";
        }
    }

    public static int executeCommand(String cmd, AccountList aList, CurrencyList cList, ItemList iList){
        UI ui = new UI();
        int result = 0;
        if(cmd.toUpperCase().equals("EXIT")){
            System.out.println("By by...");
            System.exit(1);
            result = 1;
        }
        else if(cmd.toUpperCase().equals("ADD ACCOUNT")){
            aList.add(ui.createAccount(aList));
            result = 1;
        }
        else if(cmd.toUpperCase().equals("PRINT ACCOUNT LIST")){
            ui.printAccountList(aList);
            result = 1;
        }
        else if(cmd.toUpperCase().equals("PRINT CURRENCY LIST")){
            ui.printCurrencyList(cList);
            result = 1;
        }
        else if(cmd.toUpperCase().equals("PRINT ITEM LIST")){
            ui.printItemList(iList);
            result = 1;
        }

        else{
            System.out.println("Command '" + cmd + "' is incorrect! Please type correct command.");
        }

        return result;
    }


}
