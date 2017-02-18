package HomeSoft.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * Created by admin on 12.02.17.
 */
public class UI {

    private void printOk(){
        System.out.println("[OK]");
    }

    private void printError(String message){
        System.out.println("[ERROR] " + message);
    }


    public Account createAccount(Integer id) {
        Account acc = new Account();
        String text = "";
        //HEADER
        System.out.println("Account Creating ...");
        try {
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            //PARAM #1
            acc.setId(id);
            //PARAM #2
            System.out.println("Input Account Code (String):");
            text = br.readLine();
            acc.setCode(text);
            this.printOk();
            //PARAM #3
            System.out.println("Input Account Type (String: D, C, DC):");
            text = br.readLine();
            acc.setType(AccountType.getAccountType(text));
            if (acc.getType() != AccountType.NONE) {
                this.printOk();
            } else {
                this.printError("Can not convert '" + text + "' to Account Type.");
            }
            //PARAM #4
            System.out.println("Input Account Name (String):");
            text = br.readLine();
            acc.setName(text);
            this.printOk();

            if(isr.ready()){
                isr.close();
            }
            if(br.ready()){
                br.close();
            }

        } catch (IOException ex) {
            acc = new Account();
        }

        //END

        return acc;
    }


}
