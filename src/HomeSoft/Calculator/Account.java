package HomeSoft.Calculator;

import java.util.Date;

/**
 * Created by RiP on 04.02.2017.//
 */
public abstract class Account extends EntityEx implements ConsolePrintable {

    private AccountType type;

    private void init(){
        this.type = AccountType.NONE;
    }

    public Account(Integer id, String code, String name, AccountType type) {
        super(id, code, name);
        this.init();
        this.type = type;
    }

    public Account(Integer id, String code, AccountType type) {
        super(id, code);
        this.init();
        this.type = type;
    }

    public Account(AccountType type) {
        super();
        this.init();
        this.type = type;
    }

    public Account() {
        super();
        this.init();
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        if (!super.equals(o)) return false;

        Account account = (Account) o;

        return getType() == account.getType();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "type=" + type +
                '}';
    }

    public void print() {
        System.out.print(this.toString());
    }

    public void println() {
        System.out.println(this.toString());
    }
}
