package HomeSoft.Calculator;

/**
 * Created by red7 on 2/7/2017.
 */
public class Item extends EntityHr implements ConsolePrintable, Stringable {
    private ItemType type;


    public Item(Integer id, Integer pid, String code, ItemType type, EntityHr parent) {
        super(id, pid, code, parent);
        this.type = type;
    }

    public Item(Integer id, Integer pid, String code, ItemType type) {
        super(id, pid, code,null);
        this.type = type;
    }

    public Item() {
        super(GlobalParameter.DEFAULT_ID, GlobalParameter.DEFAULT_ID, GlobalParameter.DEFAULT_CODE, null);
        this.type = ItemType.NONE;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String s = GlobalParameter.FILE_FIELD_SEPARATOR;
        StringBuilder sb = new StringBuilder("");
        sb.append("Item ");
        sb.append("{");
        sb.append("id=" + this.getId());
        sb.append(", pid=" + this.getPid());
        sb.append(", code=" + this.getCode());
        sb.append(", type=" + this.type.getShortName());
        sb.append(", pid=" + (this.getParent() != null ? this.getParent().getId() : null));
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

    public String toFile() {
        //'id;pid;level,code;type'
        String s = GlobalParameter.FILE_FIELD_SEPARATOR;
        StringBuilder sb = new StringBuilder("");
        sb.append(this.getId() + s);
        sb.append(this.getPid() + s);
        sb.append(this.getLevel() + s);
        sb.append(this.getCode() + s);
        sb.append(this.type.getShortName());
        sb.append(this.getParent().getId() + s);
        return sb.toString();
    }

    public void parseLine(String value) {
        this.setId(Integer.parseInt(value.split(";")[0]));
        this.setPid(Integer.parseInt(value.split(";")[1]));
        this.setCode(value.split(";")[2]);
        this.setType(ItemType.getItemType(value.split(";")[3]));
    }

}
