package HomeSoft.Calculator;

/**
 * Created by RiP on 2/7/2017.
 */
public enum CalculationItemType {
    NONE("N"), INPUT("I"), OUTPUT("O");

    private String shortName;

    CalculationItemType(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "ExpenseType{" +
                "short_name='" + this.shortName + '\'' +
                "} " + super.toString();
    }
}
