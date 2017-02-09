package HomeSoft.Calculator;

/**
 * Created by red7 on 2/7/2017.
 */
public class Item extends EntityHr implements ConsolePrintable, Stringable {
    private ItemType type;

    public Item(EntityHr parent, Integer id, String code, ItemType type) {
        super(parent, id, code);
        this.type = type;
    }

    public Item() {
        super(null, GlobalParameter.DEFAULT_ID, GlobalParameter.DEFAULT_CODE);
        this.type = ItemType.NONE;
    }

    private void init(){
        this.type = ItemType.NONE;
    }

    @Override
    public String toString() {
        String s = GlobalParameter.FILE_FIELD_SEPARATOR;
        StringBuilder sb = new StringBuilder("");
        sb.append("Item ");
        sb.append("{");
        sb.append("id=" + this.getId());
        sb.append(", pid=" + (this.getParent()!=null?this.getParent().getId():"null"));
        sb.append(", code=" + this.getCode());
        sb.append(", type=" + this.type.getShortName());
        sb.append(", level=" + this.getLevel());
        sb.append(", pathCode=" + this.getPathCode());
        sb.append(", pathId=" + this.getPathId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public void print() {
        System.out.print(this.toString());
    }

    @Override
    public void println() {
        System.out.println(this.toString());
    }

    @Override
    public void parseLine(String value) {
        this.setParent(null);
        this.setId(GlobalParameter.DEFAULT_ID);
        this.setCode(GlobalParameter.DEFAULT_CODE);
        this.init();
    }

    @Override
    public String toFile() {
        return null;
    }
}
