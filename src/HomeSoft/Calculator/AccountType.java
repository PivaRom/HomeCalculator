package HomeSoft.Calculator;

/**
 * Created by RiP on 04.02.2017.
 */
public enum AccountType {
    NONE("N"), DEBIT("D"), CREDIT("C"), DEBIT_CREDIT("DC");

    private String shortName;

    AccountType(String shortName) {
        this.shortName = shortName;
    }

    public static AccountType getAccountType(String value){
        AccountType result = AccountType.NONE;
        for(AccountType at: AccountType.values()){
            if(value.equals(at.getShortName())){
                result = at;
                break;
            }
        }
        return result;
    }

    public String getShortName() {
        return shortName;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "short_name='" + this.shortName + '\'' +
                "} " + super.toString();
    }
}
