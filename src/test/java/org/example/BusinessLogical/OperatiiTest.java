package org.example.BusinessLogical;

import org.example.DataModels.Polinom;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperatiiTest {
    Polinom polinom1 = new Polinom();
    Polinom polinom2 = new Polinom();

    @BeforeEach
    public void init(){
        this.polinom1 = Regex.computeInputString("2.0x^3+4.0x^2-1.0x^1-2.0x^0");
        this.polinom2 = Regex.computeInputString("-4.0x^1+5.0x^0");
    }

    @Test
    public void validAdditionPolinomsTest() {
        Polinom p3 =  Operatii.additionPolinoms(this.polinom1, this.polinom2);
            assertEquals("+2.0x^3+4.0x^2-5.0x^1+3.0x^0",p3.toString());
    }

    @Test
    void invalidAdditionPolinomsTest() {
        assertNotEquals("3.0x^2-10x^0",Operatii.additionPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void validSubstractPolinomsTest() {
        assertEquals("+2.0x^3+4.0x^2+3.0x^1-7.0x^0",Operatii.substractPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void invalidSubstractPolinomsTest() {
        assertNotEquals("+7.0x^0",Operatii.substractPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void validMultiplyPolinomsTest() {
        assertEquals("-8.0x^4+6.0x^3+4.0x^2+2.0x^1-10.0x^0",Operatii.multiplyPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void invalidMultiplyPolinomsTest() {
        assertNotEquals("+26.0x^3+16.0x^2--10.0x^0",Operatii.multiplyPolinoms(polinom1,polinom2).toString());
    }

    @Test
    void validDerivatePolinomTest() {
        assertEquals("+6.0x^2+8.0x^1-1.0x^0+-0.0x^-1",Operatii.derivatePolinom(polinom1).toString());
    }

    @Test
    void invalidDerivatePolinomTest() {
        assertNotEquals("+6.0x^2-1.0x^0",Operatii.derivatePolinom(polinom1).toString());
    }

    @Test
    void validIntegratePolinomTest() {
        assertEquals("+0.5x^4+1.3333334x^3-0.5x^2-2.0x^1",Operatii.integratePolinom(polinom1).toString());
    }

    @Test
    void invalidIntegratePolinomTest() {
        assertNotEquals("+0.5x^2-2.0x^1",Operatii.integratePolinom(polinom1).toString());
    }
}
