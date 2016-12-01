package com.example.estebancastro.asignacionno2.Factorial;

/**
 * Created by ESTEBAN CASTRO on 21/11/2016.
 */

public class FactorialUtil {


    private long numberInput = 1;

    public FactorialUtil(long number) {
        numberInput = number;
    }

    public long calculateFactorial() {
        long returnFactorialNumber = 1;

        for (long i = 1; i <= numberInput; i++) {
            returnFactorialNumber = returnFactorialNumber * i;
        }

        return returnFactorialNumber;
    }

}
