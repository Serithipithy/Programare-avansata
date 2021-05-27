package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info {
    public void about(Locale locale) {
        StringBuilder about = new StringBuilder();

        about.append(getCountry(locale)).append("\n");
        about.append(getLanguage(locale)).append("\n");
        about.append(getCurrency(locale)).append("\n");
        about.append(getWeekDays(locale)).append("\n");
        about.append(getMonths(locale)).append("\n");
        about.append(getToday(locale)).append("\n");

        System.out.println(about.toString());
    }
    public String getCountry(Locale locale){
        return "Country: " + locale.getDisplayCountry(Locale.US) + " ("+ locale.getDisplayCountry(locale) +")";
    }

    public String getLanguage(Locale locale){
        return "Language: " + locale.getDisplayLanguage(Locale.US) + " ("+ locale.getDisplayLanguage(locale) +")";
    }

    public String getCurrency(Locale locale){
        Currency currency = Currency.getInstance(locale);
        return "Currency: " + currency.getCurrencyCode() + " ("+ currency.getDisplayName() +")";
    }

    public String getWeekDays(Locale locale){
        StringBuilder weekDaysString = new StringBuilder();

        String[] weekDays = DateFormatSymbols.getInstance(locale).getWeekdays();

        weekDaysString.append("Week Days: ");
        weekDaysString.append(weekDays[1]);

        for(int i = 2; i < weekDays.length; i++)
        {
            weekDaysString.append(", ").append(weekDays[i]);
        }

        return weekDaysString.toString();
    }

    public String getMonths(Locale locale){
        StringBuilder monthsString = new StringBuilder();
        String[] months = DateFormatSymbols.getInstance(locale).getMonths();

        monthsString.append("Months: ");
        monthsString.append(months[0]);

        for(int i = 1; i < months.length - 1; i++)
        {
            monthsString.append(", ").append(months[i]);
        }

        return monthsString.toString();
    }

    private String getToday(Locale locale) {
        return "Today: " + DateFormat.getDateInstance(DateFormat.LONG, Locale.US).format(new Date()) + " (" +
                DateFormat.getDateInstance(DateFormat.LONG, locale).format(new Date()) + ")";
    }
}
