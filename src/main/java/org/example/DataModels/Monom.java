package org.example.DataModels;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Monom {
    private float coef;
    private int exp;

    public Monom(float coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public int compareTo(Monom m) {
        Integer exp = this.exp;
        Integer exp1 = m.exp;
        return exp.compareTo(exp1);
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public float getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }

}
