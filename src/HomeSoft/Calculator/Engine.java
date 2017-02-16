package HomeSoft.Calculator;

import java.io.IOException;

/**
 * Created by RiP on 15.02.2017.
 */
public class Engine {

    public static void main(String[] arg){
        run();
    }

    public static void run()  {
        boolean canExit = false;
        ConsoleHelper ch = new ConsoleHelper();
        ch.printLine("Hellow User! What would you like?");
        String cmd = "";
        AccountList aList = new AccountList();
        aList.readFile("production//HomeCalculator//HomeSoft//Calculator/Account.txt");

        while ( canExit != true){
            try {
                ch = new ConsoleHelper();
                cmd = ch.readLine();
                if (executeCommand(cmd, aList) == 1){
                    ch.printResultOk();
                }
                if(cmd.toUpperCase() == "EXIT"){
                    canExit = false;
                    System.out.println("By by...");
                    System.exit(1);
                }
            }
            catch(IOException ex){

                ch.printLine(ex.getMessage());
            }
        }
    }

    public static int executeCommand(String cmd, AccountList aList){
        UI ui = new UI();
        int result = 0;
        if(cmd.toUpperCase() == "EXIT"){
            result = 1;

        }
        else if(cmd.toUpperCase().equals("ADD ACCOUNT")){
            aList.add(ui.createAccount(aList.size()));
            result = 1;
        }
        return result;
    }


}
