package HomeSoft.Calculator;


/**
 * Created by admin on 12.02.17.
 */
public class UI {

    public void printAccountList(AccountList aList) {
        //HEADER
        System.out.println("Print ...");
        aList.println();
        //END
    }

    public Account createAccount(AccountList aList) {
        Account acc = new Account();
        String text = "";
        ConsoleHelper ch = new ConsoleHelper();

        //HEADER
        System.out.println("Account Creating ...");

        //PARAM #1
        acc.setId(aList.size());

        //PARAM #2
        text = ch.inputString("Input Account Code (String):");
        acc.setCode(text);
        ch.printResultOk();

        //PARAM #3
        text = ch.inputString("Input Account Type (String: D, C, DC):");
        acc.setType(AccountType.getAccountType(text.toUpperCase()));
        if (acc.getType() != AccountType.NONE) {
            ch.printResultOk();
        } else {
            ch.printResultError("Can not convert '" + text + "' to Account Type.");
        }

        //PARAM #4
        text = ch.inputString("Input Account Name (String):");
        acc.setName(text);
        ch.printResultOk();

        //END
        return acc;
    }

    public void printCurrencyList(CurrencyList сList) {
        //HEADER
        System.out.println("Print ...");
        сList.println();
        //END
    }

    public void printItemList(ItemList iList) {
        //HEADER
        System.out.println("Print ...");
        iList.println();
        //END
    }




}
