package HomeSoft.Calculator;

import java.util.Date;

/**
 * Created by RiP on 20.01.2017.
 */
public class Currency extends EntityEx implements ConsolePrintable {

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

    public String toString() {
        return super.toString();
    }

    public void println(){
        System.out.println(this.toString());
    }

    public void print(){
        System.out.print(this.toString());
    }

    public String toFile() {
        String s = GlobalParameter.FILE_FIELD_SEPARATOR;
        StringBuilder sb = new StringBuilder("");
        sb.append(this.getId() + s);
        sb.append(this.getCode() + s);
        sb.append(this.getName());
        return sb.toString();
    }


}
