package HomeSoft.Calculator;

/**
 * Created by RiP on 20.01.2017.
 */
public class Currency extends EntityEx implements ConsolePrintable, Stringable {

    public Currency(Integer id, String code, String name) {
        super(id, code, name);
    }

    public Currency(Integer id, String code) {
        super(id, code);
    }

    public Currency() {
    }

    public Integer getId() {
        return super.getId();
    }

    public void setId(Integer id) {
        super.setId(id);
    }

    public String getCode() {
        return super.getCode();
    }

    public void setCode(String code) {
        super.setCode(code);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public boolean equals(Object o) {
        return super.equals(o);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void println(){
        System.out.println(this.toString());
    }

    public void print(){
        System.out.print(this.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("Currency{");
        sb.append("id='" + this.getId() + "'");
        sb.append(", code='" + this.getCode() + "'");
        sb.append(", name='" + this.getName() + "'");
        sb.append("}");
        return sb.toString();
    }

    public String toFile() {
        String s = GlobalParameter.FILE_FIELD_SEPARATOR;
        StringBuilder sb = new StringBuilder("");
        sb.append(this.getId() + s);
        sb.append(this.getCode() + s);
        sb.append(this.getName());
        return sb.toString();
    }

    public void parseLine(String value) {
        this.setId(Integer.parseInt(value.split(";")[0]));
        this.setCode(value.split(";")[1]);
        this.setName(value.split(";")[2]);
    }


}
