package org.example.BusinessLogical;

import org.example.DataModels.Polinom;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperatiiTestOLD {

    Polinom polinom1 = new Polinom();
    Polinom polinom2 = new Polinom();

    @Before
    public void init() {
        polinom1 = Regex.computeInputString("2.0x^3+4.0x^2-1.0x^1-2.0x^0");
        polinom2 = Regex.computeInputString("-4.0x^1+5.0x^0");

        System.out.println("LOG INITIALIZARE:\n");
        System.out.println(polinom1.toString() + "\n" + polinom2.toString() + "\n");
    }

    @Test
    void validAdditionPolinomsTest() {
        System.out.println("LOG:\n");
        System.out.println(polinom1.toString() + "\n" + polinom2.toString() + "\n");
        assertEquals("2.0x^3+4.0x^2+3.0x^1+3.0x^0", Operatii.additionPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void invalidAdditionPolinomsTest() {
        System.out.println("\n" + polinom1.toString() + polinom2.toString() + "\n");
        assertEquals("3.0x^2-10x^0",Operatii.additionPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void validSubstractPolinomsTest() {
        System.out.println("\n" + polinom1.toString() + polinom2.toString() + "\n");
        assertEquals("+2.0x^3+4.0x^2+5.0x^1+7.0x^0",Operatii.substractPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void invalidSubstractPolinomsTest() {
        System.out.println("\n" + polinom1.toString() + polinom2.toString() + "\n");
        assertEquals("+7.0x^0",Operatii.substractPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void validMultiplyPolinomsTest() {
        System.out.println("\n" + polinom1.toString() + polinom2.toString() + "\n");
        assertEquals("+8.0x^4+26.0x^3+16.0x^2-13.0x^1-10.0x^0",Operatii.multiplyPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void invalidMultiplyPolinomsTest() {
        System.out.println("\n" + polinom1.toString() + polinom2.toString() + "\n");
        assertEquals("+26.0x^3+16.0x^2--10.0x^0",Operatii.multiplyPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void validDerivatePolinomTest() {
        System.out.println("\n" + polinom1.toString() + "\n");
        assertEquals("+6.0x^2+8.0x^1-1.0x^0",Operatii.derivatePolinom(polinom1).toString());
    }

    @Test
    void invalidDerivatePolinomTest() {
        System.out.println("\n" + polinom1.toString() + "\n");
        assertEquals("+6.0x^2-1.0x^0",Operatii.derivatePolinom(polinom1).toString());
    }

    @Test
    void validIntegratePolinomTest() {
        System.out.println("\n" + polinom1.toString() + "\n");
        assertEquals("+0.5x^4+1.3333334x^3-0.5x^2-2.0x^1",Operatii.integratePolinom(polinom1).toString());
    }

    @Test
    void invalidIntegratePolinomTest() {
        System.out.println("\n" + polinom1.toString() + "\n");
        assertEquals("+0.5x^2-2.0x^1",Operatii.integratePolinom(polinom1).toString());
    }
}