package HomeSoft.Calculator;

/**
 * Created by RiP on 04.02.2017.
 */
public abstract class EntityHr {
    private Integer id;
    private Integer pid;
    private String code;

    private void init(){
        this.id = new Integer(-1);
        this.pid = new Integer(-1);
        this.code = "";
    }

    public EntityHr(Integer id, Integer pid, String code) {
        this.init();
        this.id = id;
        this.pid = pid;
        this.code = code;
    }

    public EntityHr() {
        this.init();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityHr)) return false;

        EntityHr that = (EntityHr) o;

        if (!getId().equals(that.getId())) return false;
        if (getPid() != null ? !getPid().equals(that.getPid()) : that.getPid() != null) return false;
        return getCode().equals(that.getCode());
    }

    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getPid() != null ? getPid().hashCode() : 0);
        result = 31 * result + getCode().hashCode();
        return result;
    }

    public String toString() {
        return "EntityHr{" +
                "id=" + id +
                ", pid=" + pid +
                ", code='" + code + '\'' +
                '}';
    }
}
