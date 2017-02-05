package HomeSoft.Calculator;

import java.util.Date;

/**
 * Created by RiP on 04.02.2017.
 */
public abstract class EntityLog {
    private Integer id;
    private String title;
    private Date date;

    private void init(){
        this.id = new Integer(-1);
        this.title = "";
    }

    public EntityLog(Integer id, String title, Date date) {
        this.init();
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public EntityLog() {
        this.init();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityLog)) return false;

        EntityLog EntityLog = (EntityLog) o;

        if (!getId().equals(EntityLog.getId())) return false;
        if (!getTitle().equals(EntityLog.getTitle())) return false;
        return getDate().equals(EntityLog.getDate());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "EntityLog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }



}
