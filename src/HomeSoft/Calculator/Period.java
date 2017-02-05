package HomeSoft.Calculator;

import java.util.Date;

/**
 * Created by RiP on 04.02.2017.
 */
public class Period extends Entity implements  ConsolePrintable {
    private Date dateFrom;
    private Date dateTo;

    private void init(){
        this.dateFrom = new Date();
        this.dateTo = new Date();
    }

    public Period(Integer id, String code, Date dateFrom, Date dateTo) {
        super(id, code);
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Period(Date dateFrom, Date dateTo) {
        super();
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Period() {
        super();
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Period)) return false;
        if (!super.equals(o)) return false;

        Period period = (Period) o;

        if (!getDateFrom().equals(period.getDateFrom())) return false;
        return getDateTo().equals(period.getDateTo());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getDateFrom().hashCode();
        result = 31 * result + getDateTo().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Period{" +
                "dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }

    public void print() {
        System.out.print(this.toString());
    }

    public void println() {
        System.out.println(this.toString());
    }
}
