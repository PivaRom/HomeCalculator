package HomeSoft.Calculator;


import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by RiP on 04.02.2017.
 */
public class ExchangeList extends ArrayList<Exchange> {

   public ExchangeList(int initialCapacity) {
      super(initialCapacity);
   }

   public ExchangeList() {
   }

   public ExchangeList(Collection<? extends Exchange> c) {
      super(c);
   }

   @Override
   public String toString() {
      return "ExchangeList{}";
   }


}
