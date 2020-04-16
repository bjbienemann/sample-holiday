package com.agilliza.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class HolidayUtilsTest {

    private int year;

    @Before
    public void before() {
        year = 2019;
    }

    @Test
    public void testCarnaval2019() {
        LocalDate carnaval2019 = LocalDate.of(year, 3, 5);
        Assert.assertEquals(carnaval2019, HolidayUtils.getCarnavalHolidayByYear(year));
    }

    @Test
    public void testSextaFeiraSanta2019() {
        LocalDate sextaFeiraSanta2019 = LocalDate.of(year, 4, 19);
        Assert.assertEquals(sextaFeiraSanta2019, HolidayUtils.getSextaFeiraSantaHolidayByYear(year));
    }

    @Test
    public void testPascoa2019() {
        LocalDate pascoa2019 = LocalDate.of(year, 4, 21);
        Assert.assertEquals(pascoa2019, HolidayUtils.getPascoaHolidayByYear(year));
    }

    @Test
    public void testCorpusChristi2019() {
        LocalDate corpusChristi2019 = LocalDate.of(year, 6, 20);
        Assert.assertEquals(corpusChristi2019, HolidayUtils.getCorpusChristiHolidayByYear(year));
    }
}

