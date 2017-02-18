package HomeSoft.Calculator;

/**
 * Created by RiP on 2/7/2017.
 */
public enum ItemType {
    NONE("N"), INPUT("I"), OUTPUT("O");

    private String shortName;

    ItemType(String shortName) {
        this.shortName = shortName;
    }

    public static ItemType getItemType(String value){
        ItemType result = ItemType.NONE;
        for(ItemType it: ItemType.values()){
            if(value.toUpperCase().equals(it.getShortName().toUpperCase())){
                result = it;
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
        return "ItemType{" +
                "short_name='" + this.shortName + '\'' +
                "} " + super.toString();
    }
}
