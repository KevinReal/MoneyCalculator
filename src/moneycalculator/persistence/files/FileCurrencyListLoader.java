package moneycalculator.persistence.files;

import moneycalculator.model.Currency;
import moneycalculator.persistence.CurrencyListLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCurrencyListLoader implements CurrencyListLoader{

    private final String filename;

    public FileCurrencyListLoader(String filename) {
        this.filename = filename;
    }

    @Override
    public Currency[] currencies() {
        List<Currency> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                list.add(currencyOf(line));
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return list.toArray(new Currency[0]);
    }

    private Currency currencyOf(String line) {
        String [] partsOfCurrency = line.split(",");
        return new Currency(partsOfCurrency[0], partsOfCurrency[1], partsOfCurrency[2]);
    }
}
