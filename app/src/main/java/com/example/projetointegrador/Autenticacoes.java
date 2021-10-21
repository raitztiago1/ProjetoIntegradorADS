package com.example.projetointegrador;

import java.util.InputMismatchException;

public class Autenticacoes {

    public boolean validaPfPj(String changeDoc){
        if (changeDoc.equals("00000000000") || changeDoc.equals("11111111111") ||
                changeDoc.equals("22222222222") || changeDoc.equals("33333333333") ||
                changeDoc.equals("44444444444") || changeDoc.equals("55555555555") ||
                changeDoc.equals("66666666666") || changeDoc.equals("77777777777") ||
                changeDoc.equals("88888888888") || changeDoc.equals("99999999999") ||
                (changeDoc.length() != 11)){
            return(false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(changeDoc.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48);
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(changeDoc.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            if ((dig10 == changeDoc.charAt(9)) && (dig11 == changeDoc.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }


}
