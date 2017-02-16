package HomeSoft.Calculator;

import java.io.IOException;

/**
 * Created by admin on 12.02.17.
 */
public class UI {




    public Account createAccount(Integer id) {
        ConsoleHelper ch = new ConsoleHelper();
        Account acc = new Account();
        String text = "";
        //HEADER
        ch.printLine("Account Creating ...");
        try {
            //PARAM #1
            acc.setId(id);
            //PARAM #2
            acc.setCode(ch.inputString("Input Account Code (String):"));
            ch.printResultOk();
            //PARAM #3
            acc.setType(AccountType.getAccountType(ch.inputString("Input Account Type (String: D, C, DC):")));
            if (acc.getType() != AccountType.NONE) {
                ch.printResultOk();
            } else {
                ch.printResultError();
            }
            //PARAM #4
            acc.setName(ch.inputString("Input Account Name (String):"));
        } catch (IOException ex) {
            //PARAM #1
            acc.setId(id);
            //PARAM #2
            acc.setCode("NONE");
            //PARAM #3
            acc.setType(AccountType.NONE);
            //PARAM #4
            acc.setName("NONE");
        }
        //END
        return acc;
    }


}
