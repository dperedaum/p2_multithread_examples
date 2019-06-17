package uy.edu.um.prog2.multithread.example4;

import uy.edu.um.prog2.multithread.example2.Example2Main;

public class Example4Main {

    private String var1;

    private String var2;

    public Example4Main() {
        var1 = "Hola";
        var2 = "Mundo";
    }


    public void taskA() {
        synchronized (this.var1) {

/*            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            synchronized (this.var2) {

                System.out.println("Prueba deadLock 1");

            }

        }
    }

    public void taskB() {
        synchronized (this.var2) {

            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            synchronized (this.var1) {

                System.out.println("Prueba deadLock 2");

            }

        }
    }

    public static void main(String[] args) {
        Example4Main example4 = new Example4Main();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                example4.taskA();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example4.taskB();
            }
        });

        thread1.start();
        thread2.start();
    }
}
