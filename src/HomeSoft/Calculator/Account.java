package HomeSoft.Calculator;

/**
 * Created by RiP on 04.02.2017.//
 */
public class Account extends EntityEx implements ConsolePrintable, Stringable {

    private AccountType type;

    public Account(AccountType type, Integer id, String code, String name) {
        super(id, code, name);
        this.init();
        this.type = type;
    }

    public Account(AccountType type, Integer id, String code) {
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

    private void init(){
        this.type = AccountType.NONE;
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



    public void print() {
        System.out.print(this.toString());
    }

    public void println() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("Account{");
        sb.append("id='" + this.getId() + "'");
        sb.append(", code='" + this.getCode() + "'");
        sb.append(", name='" + this.getName() + "'");
        sb.append(", type='" + this.type + "'");
        sb.append("}");
        return sb.toString();
    }

    public String toFile() {
        String s = GlobalParameter.FILE_FIELD_SEPARATOR;
        StringBuilder sb = new StringBuilder("");
        sb.append(this.getId() + s);
        sb.append(this.getCode() + s);
        sb.append(this.getName() + s);
        sb.append(this.type.getShortName());
        return sb.toString();
    }

    public void parseLine(String value) {
        this.setId(Integer.parseInt(value.split(";")[0]));
        this.setCode(value.split(";")[1]);
        this.setName(value.split(";")[2]);
        this.setType(AccountType.getAccountType(value.split(";")[3]));
    }
}
