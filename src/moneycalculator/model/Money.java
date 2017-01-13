package moneycalculator.model;

public class Money {
    private final double amount;
    private final Currency curreny;

    public Money(double amount, Currency curreny) {
        this.amount = amount;
        this.curreny = curreny;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurreny() {
        return curreny;
    }
}
