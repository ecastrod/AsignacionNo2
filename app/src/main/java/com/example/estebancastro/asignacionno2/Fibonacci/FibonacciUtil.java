package com.example.estebancastro.asignacionno2.Fibonacci;

/**
 * Created by ESTEBAN CASTRO on 21/11/2016.
 */

public class FibonacciUtil {


    private long numberInput = 0;

    public FibonacciUtil(long number) {
        numberInput = number;
    }

    public long calculateFibonacci() {
        return CalcularFibonacci(numberInput);
    }

    public long CalcularFibonacci(long numberToCalc) {
        if (numberToCalc == 0)
            return 0;
        else if (numberToCalc == 1)
            return 1;
        else {
            return CalcularFibonacci(numberToCalc - 1) + CalcularFibonacci(numberToCalc - 2);
        }
    }

}
