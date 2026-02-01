package main.java.com.example;

public class Calculator {

    public enum Operation {
        ADD {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        },
        SUBTRACT {
            @Override
            public int apply(int a, int b) {
                return a - b;
            }
        },
        MULTIPLY {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        },
        DIVIDE {
            @Override
            public int apply(int a, int b) {
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return a / b;
            }
        },
        MODULO {
            @Override
            public int apply(int a, int b) {
                return a % b;
            }
        },
        POWER {
            @Override
            public int apply(int a, int b) {
                return (int) Math.pow(a, b);
            }
        };

        public abstract int apply(int a, int b);
    }

    public int calculate(int a, int b, Operation operation) {
        return operation.apply(a, b);
    }
}
