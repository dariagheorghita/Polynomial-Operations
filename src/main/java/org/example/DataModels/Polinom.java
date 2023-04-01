package org.example.DataModels;

import lombok.Getter;
import lombok.Setter;
import org.example.DataModels.Monom;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter

public class Polinom {
    private Map<Integer, Monom> monoms = new HashMap<Integer, Monom>();

    public Map<Integer, Monom> getPolinom() {
        return monoms;
    }

    @Override
    public String toString() {
        String string="";
        for(Monom m: getPolinom().values()){
            if(m.getCoef()<0){
                string=(m.getCoef() + "x^" + m.getExp())+string;
            }
            else{
                string=("+" + m.getCoef() + "x^" + m.getExp()) + string;
            }
        }
        return string;
    }
}
