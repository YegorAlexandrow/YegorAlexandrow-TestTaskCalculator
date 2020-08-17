package com.yegoralexandrow;


import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalcTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void simpleArithmetics() {
        assertEquals(Main.calculate("1 + 2").toString(), "3");
        assertEquals(Main.calculate("III + IV").toString(), "VII");
        assertEquals(Main.calculate("VI / II").toString(), "III");
        assertEquals(Main.calculate("IX * X").toString(), "XC");
        assertEquals(Main.calculate("10 * 10").toString(), "100");
        assertEquals(Main.calculate("10 - 9").toString(), "1");
        assertEquals(Main.calculate("VIII - III").toString(), "V");
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void incorrectLexemesCount() {
        Main.calculate("1 +");
        assertThat(errContent.toString(), containsString("Incorrect expression!"));
    }

    @Test
    public void incorrectOperator() {
        Main.calculate("I ^ IV");
        assertThat(errContent.toString(), containsString("Incorrect expression!"));
    }

    @Test
    public void incorrectNumeralSystem() {
        Main.calculate("3 + X");
        assertThat(errContent.toString(), containsString("Incorrect expression!"));
    }

    @Test
    public void upperLimit() {
        Main.calculate("1 + 11");
        assertThat(errContent.toString(), containsString("Incorrect expression!"));
    }

    @Test
    public void lowerLimit() {
        Main.calculate("III - IV");
        assertThat(errContent.toString(), containsString("Incorrect expression!"));
    }

    @Test
    public void zeroLimit() {
        Main.calculate("3 * 0");
        assertThat(errContent.toString(), containsString("Incorrect expression!"));
    }

    @Test
    public void lowerCase() {
        assertEquals(Main.calculate("Vi / iI").toString(), "III");
    }
}
