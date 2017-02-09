package HomeSoft.Calculator;

/**
 * Created by RiP on 04.02.2017.
 */
public abstract class EntityHr {
    private EntityHr parent;
    private Integer id;
    private String code;
    private String pathId;
    private String pathCode;
    private Integer level;

    public EntityHr(EntityHr parent, Integer id, String code) {
        this.init();
        this.parent = parent;
        this.id = id;
        this.code = code;
        this.changePathId();
        this.changePathCode();
        this.changeLevel();
    }

    private void init(){
        this.parent = null;
        this.id = GlobalParameter.DEFAULT_ID;
        this.code = GlobalParameter.DEFAULT_CODE;
        this.pathId = GlobalParameter.DEFAULT_PATH_SEPARATOR + this.id;
        this.pathCode = GlobalParameter.DEFAULT_PATH_SEPARATOR + this.code;
        this.level = 0;
    }

    public void changePathId(){
        StringBuilder sb = new StringBuilder("");
        if (this.parent != null) {
            sb.append(this.parent.getPathId());
            sb.append(GlobalParameter.DEFAULT_PATH_SEPARATOR);
            sb.append(this.id);
        }
        else{
            sb.append(this.id);
        }
        this.pathId = sb.toString();
    }

    public void changePathCode(){
        StringBuilder sb = new StringBuilder("");
        if (this.parent != null) {
            sb.append(this.parent.getPathCode());
            sb.append(GlobalParameter.DEFAULT_PATH_SEPARATOR);
            sb.append(this.code);
        }
        else{
            sb.append(this.code);
        }this.pathCode = sb.toString();
    }

    public void changeLevel(){
        this.level = (this.parent!=null?this.parent.getLevel():-1)+1;
    }

    public EntityHr getParent() {
        return parent;
    }

    public void setParent(EntityHr parent) {
        this.parent = parent;
        this.changePathId();
        this.changePathCode();
        this.changeLevel();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        this.changePathId();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        this.changePathCode();
    }

    public String getPathId() {
        return pathId;
    }

    public String getPathCode() {
        return pathCode;
    }

    public Integer getLevel() {
        return level;
    }
}
