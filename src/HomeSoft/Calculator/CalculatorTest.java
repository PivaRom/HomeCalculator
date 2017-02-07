package HomeSoft.Calculator;

import java.io.IOException;

/**
 * Created by RiP on 04.02.2017.//
 */
public class CalculatorTest {

   public static void main(String[] args) throws IOException {
      CurrencyList cList = new CurrencyList();
      String current = new java.io.File( "." ).getCanonicalPath();
      current += "\\out\\production\\HomeCalculator\\HomeSoft\\Calculator";
      //cList.add(cList.parseLine("1;UAH;ggr"));
      //cList.add(cList.parseLine("2;USA;Dollear bla"));

      cList.println();

      cList.readFile(current +"\\"+"Currency.txt");
      cList.println();
      cList.get(0).setId(981);
      cList.println();

      cList.writeFile(current +"\\"+"Currency.txt");
      cList.readFile(current +"\\"+"Currency.txt");
      cList.println();

       Account acc = new Account(AccountType.DEBIT,1,"Acc1","Acc1");
       acc.println();
       Account acc2 = new Account(AccountType.CREDIT, 2,"Acc2","Acc2");
       acc2.println();

       AccountList aLst = new AccountList();
       aLst.readFile(current +"\\"+"Account.txt");
       aLst.println();

       ItemList iLst = new ItemList();
       iLst.readFile(current +"\\"+"Item.txt");
       iLst.println();


   }
}
