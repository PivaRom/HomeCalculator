package HomeSoft.Calculator;

import java.io.IOException;

/**
 * Created by admin on 12.02.17.
 */
public class UI {



    public Account createAccount(Integer id) throws IOException {
        ConsoleHelper ch = new ConsoleHelper();
        Account acc = new Account();
        String text = "";
        ch.printLine("Account Creating ...");
        acc.setId(id);
        acc.setCode(ch.inputString("Input Account Code (String):"));
        acc.setType(AccountType.getAccountType(ch.inputString("Input Account Type (String):")));
        acc.setName(ch.inputString("Input Account Name (String):"));
        ch.streamClose();
        return acc;
    }
}
