package moneycalculator.main;

import moneycalculator.control.CalculateCommand;
import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.persistence.cloud.RestExchangeRateLoader;
import moneycalculator.persistence.files.FileCurrencyListLoader;

public class Main {

    public static void main (String [] args) {
        CurrencyListLoader currencyLoader = new FileCurrencyListLoader("C:\Users\Desktop\Currencies");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencyLoader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDisplay(), mainFrame.getMoneyDialog(), exchangeRateLoader));
    }

}
