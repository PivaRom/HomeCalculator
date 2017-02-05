package HomeSoft.Calculator;

/**
 * Created by RiP on 04.02.2017.
 */
public abstract class EntityEx {
    private Integer id;
    private String code;
    private String name;

    private void init (){
        this.id = new Integer(-1);
        this.code = "";
        this.name = "";
    }

    public EntityEx(Integer id, String code, String name) {
        this.init();
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public EntityEx(Integer id, String code) {
        this.init();
        this.id = id;
        this.code = code;
    }

    public EntityEx() {
        this.init();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityEx)) return false;

        EntityEx that = (EntityEx) o;

        if (!getId().equals(that.getId())) return false;
        if (!getCode().equals(that.getCode())) return false;
        return getName().equals(that.getName());
    }

    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCode().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    public String toString() {
        return "EntityEx{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
