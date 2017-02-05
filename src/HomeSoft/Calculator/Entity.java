package HomeSoft.Calculator;

/**
 * Created by RiP on 04.02.2017.
 */
public abstract class Entity {
    private Integer id;
    private String code;

    private void init(){
        this.id = new Integer(-1);
        this.code = "";
    }

    public Entity(Integer id, String code) {
        this.init();
        this.id = id;
        this.code = code;
    }

    public Entity() {
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;

        Entity listItem = (Entity) o;

        if (!getId().equals(listItem.getId())) return false;
        return getCode().equals(listItem.getCode());
    }

    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCode().hashCode();
        return result;
    }

    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
