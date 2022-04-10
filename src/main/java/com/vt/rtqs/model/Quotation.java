package com.vt.rtqs.model;
enum QuotationType {
    open,high,low,bid,ask
}
public class Quotation {
    private String symbol;
    private QuotationType quotationType;
    private Float quotationValue;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Float getquotationValue() {
        return quotationValue;
    }

    public void setquotationValue(Float quotationValue) {
        this.quotationValue = quotationValue;
    }

    public QuotationType getQuotationType() {
        return quotationType;
    }

    public void setQuotationType(QuotationType quotationType) {
        this.quotationType = quotationType;
    }

    @Override
    public String toString()
    {
        return "[symbol"
                + symbol
                + ", quotationType="
                + quotationType
                + ", quotationValue="
                + quotationValue + "]";
    }

}
