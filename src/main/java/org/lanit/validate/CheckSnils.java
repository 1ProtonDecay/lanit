package org.lanit.snils.validate;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckSnils {
    public boolean validate(String s) {
        String[] snils = s.split(" ");
        snils[0] = snils[0].replaceAll("-", "");

        int sum = 0;
        for (int i = 0;i < snils[0].length(); i++)
            sum += (snils[0].charAt(i) - '0') * (9 - i);
        sum = sum % 101;

        if (sum == 100 || sum == 0)
            return snils[1].equals("00");

        int num = Integer.parseInt(snils[1]);
        return sum == num;
    }
}
