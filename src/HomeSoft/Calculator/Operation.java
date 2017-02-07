package HomeSoft.Calculator;

import java.util.Date;

/**
 * Created by red7 on 2/7/2017.
 */
public class Operation extends EntityLog implements ConsolePrintable, Stringable {
    private Account fromAccount;
    private Account toAccount;
    private Currency opeartionCurrecy;
    private Currency baseCurrecy;
    private Double opeartionSumm;
    private Double baseSumm;
    private Double coeficiaent;

    public Operation(Integer id, String title, Date date, Account fromAccount, Account toAccount, Currency opeartionCurrecy, Currency baseCurrecy, Double opeartionSumm, Double baseSumm, Double coeficiaent) {
        super(id, title, date);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.opeartionCurrecy = opeartionCurrecy;
        this.baseCurrecy = baseCurrecy;
        this.opeartionSumm = opeartionSumm;
        this.baseSumm = baseSumm;
        this.coeficiaent = coeficiaent;
    }

    public Operation(Account fromAccount, Account toAccount, Currency opeartionCurrecy, Currency baseCurrecy, Double opeartionSumm, Double baseSumm, Double coeficiaent) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.opeartionCurrecy = opeartionCurrecy;
        this.baseCurrecy = baseCurrecy;
        this.opeartionSumm = opeartionSumm;
        this.baseSumm = baseSumm;
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

    public Currency getOpeartionCurrecy() {
        return opeartionCurrecy;
    }

    public void setOpeartionCurrecy(Currency opeartionCurrecy) {
        this.opeartionCurrecy = opeartionCurrecy;
    }

    public Currency getBaseCurrecy() {
        return baseCurrecy;
    }

    public void setBaseCurrecy(Currency baseCurrecy) {
        this.baseCurrecy = baseCurrecy;
    }

    public Double getOpeartionSumm() {
        return opeartionSumm;
    }

    public void setOpeartionSumm(Double opeartionSumm) {
        this.opeartionSumm = opeartionSumm;
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

    @Override
    public String toString() {
        return "Operation{" +
                "fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", opeartionCurrecy=" + opeartionCurrecy +
                ", baseCurrecy=" + baseCurrecy +
                ", opeartionSumm=" + opeartionSumm +
                ", baseSumm=" + baseSumm +
                ", coeficiaent=" + coeficiaent +
                "} " + super.toString();
    }

    @Override
    public void print() {

    }

    @Override
    public void println() {

    }

    @Override
    public void parseLine(String value) {

    }

    @Override
    public String toFile() {
        return null;
    }
}
