package Java6;

class CustomThread implements Runnable {
    public void run() {
        int i = 0;
        while (i < 300) {
            System.out.println("My thread is Good");
            System.out.println("I am Good");
            i++;
        }
    }
}

class CustomThread2 implements Runnable {
    public void run() {
        int i = 0;
        while (i < 300) {
            System.out.println("My thread is Running");
            System.out.println("thread run ");
            i++;
        }
    }
}

public class RunnableThread{
    public static void main(String[] args) {
        CustomThread bullet1 = new CustomThread();
        Thread gun1 = new Thread(bullet1);
        CustomThread2 bullet2 = new CustomThread2();
        Thread gun2 = new Thread(bullet2);
        gun1.start();
        gun2.start();
    }
}
