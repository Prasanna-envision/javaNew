package com.envision.javanew.service;

interface Calculator {

    int substract(int i1, int i2);
}
//Old way to implement abstract method
/*class CalculatorImpl implements Calculator{
    @Override
    public int substract(int i1, int i2) {
        return i2-i1;
    }
    public void resultOfSub(){
        substract(10,12);
    }
}*/
class CalculatorImpl {

    public void cal() {

        /*
         * Calculator calculator = () -> System.out.println("Switch On");
         * calculator.switchOn();
         */
        /*
         * Calculator calculator = (input) -> System.out.println("Sum : " + input);
         * calculator.sum(394);
         */
//using lambda expression
        Calculator calculator = (i1, i2) -> {
            if (i2 < i1) {
                throw new RuntimeException("message");
            } else {
                return i2 - i1;
            }
        };

        System.out.println(calculator.substract(8, 20));
    }

    // () -> {body};
}