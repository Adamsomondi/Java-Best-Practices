package org.example.lamda;

public class RunnableLambdaExample {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("inside runnable1");
            }
        };
        new Thread(runnable).start();

//Java 8  more Concise lambda syntax.

        Runnable runnableLambda = () -> {
            System.out.println("inside runnable 2");
        };
        new Thread(runnableLambda).start();
    }
}