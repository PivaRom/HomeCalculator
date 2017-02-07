package HomeSoft.Calculator;

/**
 * Created by red7 on 2/7/2017.
 */
public class Item extends EntityHr implements ConsolePrintable, Stringable {
    private ItemType type;

    public Item(Integer id, Integer pid, String code, ItemType type) {
        super(id, pid, code);
        this.type = type;
    }

    public Item(ItemType type) {
        this.type = type;
    }

    public Item() {
        this.type = ItemType.NONE;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        if (!super.equals(o)) return false;

        Item item = (Item) o;

        return getType() == item.getType();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type=" + type +
                "} " + super.toString();
    }

    @Override
    public void print() {
        System.out.print(this.toString());
    }

    @Override
    public void println() {
        System.out.println(this.toString());
    }

    public String toFile() {
        String s = GlobalParameter.FILE_FIELD_SEPARATOR;
        StringBuilder sb = new StringBuilder("");
        sb.append(this.getId() + s);
        sb.append(this.getPid() + s);
        sb.append(this.getCode() + s);
        sb.append(this.type.getShortName());
        return sb.toString();
    }

    public void parseLine(String value) {
        this.setId(Integer.parseInt(value.split(";")[0]));
        this.setPid(Integer.parseInt(value.split(";")[1]));
        this.setCode(value.split(";")[2]);
        this.setType(ItemType.getItemType(value.split(";")[3]));
    }
}
