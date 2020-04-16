package com.agilliza.sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Reference
 * https://medium.com/xamarinbrasil/lista-de-feriados-nacionais-c-c61bf68ac973
 */
public class HolidayUtils {

    public static List<LocalDate> getHolidayByCurrentYear() {
        int year = LocalDate.now().getYear();
        return getHolidayByYear(year);
    }

    public static List<LocalDate> getHolidayByYear(int year) {
        List<LocalDate> holidays = new ArrayList<>();

        holidays.add(LocalDate.of(year, 1, 1)); //Ano novo
        holidays.add(LocalDate.of(year, 4, 21));  //Tiradentes
        holidays.add(LocalDate.of(year, 5, 1)); //Dia do trabalho
        holidays.add(LocalDate.of(year, 9, 7)); //Dia da Independência do Brasil
        holidays.add(LocalDate.of(year, 10, 12));  //Nossa Senhora Aparecida
        holidays.add(LocalDate.of(year, 11, 2)); //Finados
        holidays.add(LocalDate.of(year, 11, 15)); //Proclamação da República
        holidays.add(LocalDate.of(year, 12, 25)); //Natal

        LocalDate pascoa = getPascoaHolidayByYear(year);
        LocalDate sextaSanta = getSextaFeiraSantaHolidayByYear(year);
        LocalDate carnaval = getCarnavalHolidayByYear(year);
        LocalDate corpusChristi = getCorpusChristiHolidayByYear(year);

        holidays.add(pascoa);
        holidays.add(sextaSanta);
        holidays.add(carnaval);
        holidays.add(corpusChristi);

        return holidays;
    }

    public static LocalDate getCorpusChristiHolidayByYear(int year) {
        LocalDate pascoa = getPascoaHolidayByYear(year);
        return pascoa.plusDays(60);
    }

    public static LocalDate getCarnavalHolidayByYear(int year) {
        LocalDate pascoa = getPascoaHolidayByYear(year);
        return pascoa.plusDays(-47);
    }

    public static LocalDate getSextaFeiraSantaHolidayByYear(int year) {
        LocalDate pascoa = getPascoaHolidayByYear(year);
        return pascoa.plusDays(-2);
    }

    public static LocalDate getPascoaHolidayByYear(int year) {
        int x, y;
        int a, b, c, d, e;
        int day, month;

        if (year >= 1900 && year <= 2099) {
            x = 24;
            y = 5;
        } else if (year >= 2100 && year <= 2199) {
            x = 24;
            y = 6;
        } else if (year >= 2200 && year <= 2299) {
            x = 25;
            y = 7;
        } else {
            x = 24;
            y = 5;
        }

        a = year % 19;
        b = year % 4;
        c = year % 7;
        d = (19 * a + x) % 30;
        e = (2 * b + 4 * c + 6 * d + y) % 7;

        if ((d + e) > 9) {
            day = (d + e - 9);
            month = 4;
        } else {
            day = (d + e + 22);
            month = 3;
        }

        return LocalDate.of(year, month, day);
    }
}
