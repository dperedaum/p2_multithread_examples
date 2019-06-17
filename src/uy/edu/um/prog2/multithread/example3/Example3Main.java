package uy.edu.um.prog2.multithread.example3;

import java.util.Scanner;

public class Example3Main {

    private String message;

    public void producer() {


        System.out.println("Produciendo !");

        Scanner scanner = new Scanner(System.in);
        message = scanner.nextLine();

        synchronized (this) {
            notify();
        }

    }

    public void consumer() {

        System.out.println("Esperando! por un mensaje!");

        synchronized (this) {

            try {

                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Se recibio un mensaje! : " + message);

    }

    public static void main(String[] args) throws InterruptedException {
        Example3Main example2 = new Example3Main();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                example2.producer();
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example2.consumer();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Termine!");

    }
}
