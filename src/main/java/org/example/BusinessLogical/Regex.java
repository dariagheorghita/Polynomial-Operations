package org.example.BusinessLogical;

import org.example.DataModels.Monom;
import org.example.DataModels.Polinom;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static Polinom computeInputString(String polinom){
        Polinom polinom1 = new Polinom();
        String regPattern = "([\\+\\-]?[0-9]+.[0-9]+)x\\^([0-9]+)";

        Pattern pattern = Pattern.compile(regPattern);
        Matcher matcher = pattern.matcher(polinom);

        while (matcher.find()){
            float coef = Float.parseFloat(matcher.group(1));
            int exp = Integer.parseInt(matcher.group(2));
            polinom1.getMonoms().put(exp, new Monom(coef, exp));
        }

        return polinom1;
    }
}
