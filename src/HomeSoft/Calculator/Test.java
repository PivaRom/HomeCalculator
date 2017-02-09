package HomeSoft.Calculator;

import java.io.IOException;

/**
 * Created by RiP on 04.02.2017.//
 */
public class Test {

   public static void main(String[] args) throws IOException {
        Item i1 = new Item(null,101,"Grand",ItemType.NONE);
        Item i2 = new Item(i1,102,"Father",ItemType.NONE);
        Item i3 = new Item(i2,103,"Child",ItemType.NONE);

        i1.println();
        i2.println();
        i3.println();
   }
}
