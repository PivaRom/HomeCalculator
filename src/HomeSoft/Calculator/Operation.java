package HomeSoft.Calculator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by red7 on 2/7/2017.
 */
public class Operation extends EntityLog implements ConsolePrintable {
    private Item item;
    private Currency currecy;
    private Currency baseCurrecy;
    private Double summ;
    private Double baseSumm;
    private Double coeficiaent;
    private Account fromAccount;
    private Account toAccount;

    public Operation(Integer id, String title, Date date, Item item, Currency currecy, Currency baseCurrecy, Double summ, Double baseSumm, Double coeficiaent, Account fromAccount, Account toAccount) {
        super(id, title, date);
        this.item = item;
        this.currecy = currecy;
        this.baseCurrecy = baseCurrecy;
        this.summ = summ;
        this.baseSumm = baseSumm;
        this.coeficiaent = coeficiaent;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public Operation(Item item, Currency currecy, Currency baseCurrecy, Double summ, Double baseSumm, Double coeficiaent, Account fromAccount, Account toAccount) {
        this.item = item;
        this.currecy = currecy;
        this.baseCurrecy = baseCurrecy;
        this.summ = summ;
        this.baseSumm = baseSumm;
        this.coeficiaent = coeficiaent;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    public Operation(){
        super(-1, "", new Date());
        this.item = new Item();
        this.currecy = new Currency();
        this.baseCurrecy = GlobalParameter.BASE_CURRENCY;
        this.summ = 0.0D;
        this.baseSumm = 0.0D;
        this.coeficiaent = 1.0D;
        this.fromAccount = new Account();
        this.toAccount = null;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Currency getCurrecy() {
        return currecy;
    }

    public void setCurrecy(Currency currecy) {
        this.currecy = currecy;
    }

    public Currency getBaseCurrecy() {
        return baseCurrecy;
    }

    public void setBaseCurrecy(Currency baseCurrecy) {
        this.baseCurrecy = baseCurrecy;
    }

    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }

    public Double getBaseSumm() {
        return baseSumm;
    }

    public void setBaseSumm(Double baseSumm) {
        this.baseSumm = baseSumm;
    }

    public Double getCoeficiaent() {
        return coeficiaent;
    }

    public void setCoeficiaent(Double coeficiaent) {
        this.coeficiaent = coeficiaent;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operation)) return false;
        if (!super.equals(o)) return false;

        Operation operation = (Operation) o;

        if (!getItem().equals(operation.getItem())) return false;
        if (!getCurrecy().equals(operation.getCurrecy())) return false;
        if (!getBaseCurrecy().equals(operation.getBaseCurrecy())) return false;
        if (!getSumm().equals(operation.getSumm())) return false;
        if (!getBaseSumm().equals(operation.getBaseSumm())) return false;
        if (!getCoeficiaent().equals(operation.getCoeficiaent())) return false;
        if (getFromAccount() != null ? !getFromAccount().equals(operation.getFromAccount()) : operation.getFromAccount() != null)
            return false;
        return getToAccount() != null ? getToAccount().equals(operation.getToAccount()) : operation.getToAccount() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getItem().hashCode();
        result = 31 * result + getCurrecy().hashCode();
        result = 31 * result + getBaseCurrecy().hashCode();
        result = 31 * result + getSumm().hashCode();
        result = 31 * result + getBaseSumm().hashCode();
        result = 31 * result + getCoeficiaent().hashCode();
        result = 31 * result + (getFromAccount() != null ? getFromAccount().hashCode() : 0);
        result = 31 * result + (getToAccount() != null ? getToAccount().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + super.getId() +
                ", date=" + super.getDate() +
                ", item=" + item.getCode() +
                ", currecy=" + currecy.getCode() +
                ", baseCurrecy=" + baseCurrecy.getCode() +
                ", summ=" + summ +
                ", baseSumm=" + baseSumm +
                ", coeficiaent=" + coeficiaent +
                ", fromAccount=" + fromAccount.getCode() +
                ", toAccount=" + toAccount.getCode() +
                "} " /*+ super.toString()*/;
    }

    @Override
    public void print() {
        System.out.print(this.toString());
    }

    @Override
    public void println() {
        System.out.println(this.toString());
    }

    public void parseLine(String value, CurrencyList cList, AccountList aList, ItemList iList) {
        // id;date;item;currecy;baseCurrecy;summ;baseSumm;coeficiaent;fromAccount;toAccount
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH24:mm:ss");

        this.setId(Integer.parseInt((value.split(";")[0]).trim()));
        this.setDate(new Date());
        this.setTitle("");
        this.setItem(iList.getByKey(value.split(";")[2]));
        this.setCurrecy(cList.getByKey(value.split(";")[3]));
        this.setBaseCurrecy(cList.getByKey(value.split(";")[4]));
        this.setFromAccount(aList.getByKey(value.split(";")[5]));
        this.setToAccount(aList.getByKey(value.split(";")[6]));
    }

    public String toFile() {
        return null;
    }

}
