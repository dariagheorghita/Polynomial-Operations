package org.example.BusinessLogical;


import org.example.DataModels.Monom;
import org.example.DataModels.Polinom;

public class Operatii {

    //ADUNARE
    public static Polinom additionPolinoms(Polinom p1, Polinom p2) {
        Polinom res = new Polinom();

        for (Integer m : p1.getMonoms().keySet()) {
            res.getMonoms().put(m, p1.getMonoms().get(m));
        }

        for (Integer m : p2.getMonoms().keySet()) {
            double constanta = p2.getMonoms().get(m).getCoef();
            if (res.getMonoms().containsKey(m)) {
                constanta = constanta + res.getMonoms().get(m).getCoef();
            }
        }
        return res;
    }

    //SCADERE
    public static Polinom substractPolinoms(Polinom p1, Polinom p2) {
        Polinom res = new Polinom();
        for (Integer m : p1.getMonoms().keySet()) {
            res.getMonoms().put(m, new Monom(p1.getMonoms().get(m).getCoef() * (-1), p1.getMonoms().get(m).getExp()));
        }

        for (Integer m : p2.getMonoms().keySet()) {
            double constanta = p2.getMonoms().get(m).getCoef();
            if (res.getMonoms().containsKey(m)) {
                constanta = constanta + res.getMonoms().get(m).getCoef();
            }
        }
        return res;
    }

    //INMULTIRE
    public static Polinom multiplyPolinoms(Polinom p1, Polinom p2) {
        Polinom res = new Polinom();

        for (Integer m1 : p1.getMonoms().keySet()) {
            for (Integer m2 : p2.getMonoms().keySet()) {
                Monom monomP1 = p1.getMonoms().get(m1);
                Monom monomP2 = p2.getMonoms().get(m2);
                Monom monomRes = new Monom(monomP1.getCoef() * monomP2.getCoef(), monomP1.getExp() + monomP2.getExp());
                if (res.getMonoms().containsKey(monomRes.getExp())) {
                    monomRes.setCoef(monomRes.getExp() + res.getPolinom().get(monomRes.getExp()).getExp());
                }
                res.getPolinom().put(monomRes.getExp(), monomRes);
            }
        }
        return res;
    }

    //DERIVARE
   public static Polinom derivatePolinom(Polinom pol) {
        Polinom res = new Polinom();

        for (Integer m : pol.getMonoms().keySet()) {
            Monom monom = pol.getMonoms().get(m);
            monom.setExp(monom.getExp() + 1);
            monom.setCoef(monom.getCoef() / (monom.getExp() + 1));
            res.getPolinom();
        }
        return res;
    }

    //INTEGRARE
    public static Polinom integratePolinom(Polinom pol) {
        Polinom res = new Polinom();

        for (Integer m : pol.getMonoms().keySet()) {
            Monom monom = pol.getMonoms().get(m);
            monom.setExp(monom.getExp() - 1);
            monom.setCoef(monom.getCoef() * monom.getExp());
            res.getPolinom();
        }
        return res;
    }
}
