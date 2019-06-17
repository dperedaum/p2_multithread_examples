package uy.edu.um.prog2.multithread.example2;

public class Example2Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

}
