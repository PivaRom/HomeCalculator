package HomeSoft.Calculator;

import java.util.Date;


/**
 * Created by RiP on 20.01.2017.
 */
public class Exchange extends EntityLog{
    private Currency baseCurrency;
    private Currency exchangeCurrency;
    private Double baseSum;
    private Double exchangeSum;
    private Double exchangeCoefficient;

    public Exchange(Integer id, String title, Date date, Currency baseCurrency, Currency exchangeCurrency, Double exchangeSum, Double exchangeCoefficient) {
        super(id, title, date);
        this.init();
        this.baseCurrency = baseCurrency;
        this.exchangeCurrency = exchangeCurrency;
        this.exchangeSum = exchangeSum;
        this.exchangeCoefficient = exchangeCoefficient;
    }

    public Exchange(Currency baseCurrency, Currency exchangeCurrency, Double exchangeSum, Double exchangeCoefficient) {
        super();
        this.init();
        this.baseCurrency = baseCurrency;
        this.exchangeCurrency = exchangeCurrency;
        this.exchangeSum = exchangeSum;
        this.exchangeCoefficient = exchangeCoefficient;
    }

    private void init(){
        this.baseCurrency = new Currency();
        this.exchangeCurrency = new Currency();
        this.baseSum = GlobalParameter.BASE_EXCHANGE_SUMM;
        this.exchangeSum = new Double(0);
        this.exchangeCoefficient = new Double(0);
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Currency getExchangeCurrency() {
        return exchangeCurrency;
    }

    public void setExchangeCurrency(Currency exchangeCurrency) {
        this.exchangeCurrency = exchangeCurrency;
    }

    public Double getBaseSum() {
        return baseSum;
    }

    public void setBaseSum(Double baseSum) {
        this.baseSum = baseSum;
    }

    public Double getExchangeSum() {
        return exchangeSum;
    }

    public void setExchangeSum(Double exchangeSum) {
        this.exchangeSum = exchangeSum;
    }

    public Double getExchangeCoefficient() {
        return exchangeCoefficient;
    }

    public void setExchangeCoefficient(Double exchangeCoefficient) {
        this.exchangeCoefficient = exchangeCoefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exchange)) return false;
        if (!super.equals(o)) return false;

        Exchange exchange = (Exchange) o;

        if (!getBaseCurrency().equals(exchange.getBaseCurrency())) return false;
        if (!getExchangeCurrency().equals(exchange.getExchangeCurrency())) return false;
        if (!getBaseSum().equals(exchange.getBaseSum())) return false;
        if (!getExchangeSum().equals(exchange.getExchangeSum())) return false;
        return getExchangeCoefficient().equals(exchange.getExchangeCoefficient());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getBaseCurrency().hashCode();
        result = 31 * result + getExchangeCurrency().hashCode();
        result = 31 * result + getBaseSum().hashCode();
        result = 31 * result + getExchangeSum().hashCode();
        result = 31 * result + getExchangeCoefficient().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "baseCurrency=" + baseCurrency +
                ", exchangeCurrency=" + exchangeCurrency +
                ", baseSum=" + baseSum +
                ", exchangeSum=" + exchangeSum +
                ", exchangeCoefficient=" + exchangeCoefficient +
                '}';
    }
}
