package Java6;

class customThread extends Thread{
    public  void run(){
        int i =0;
        while (i<300) {
            System.out.println("My thread is Good Runnable");
            System.out.println("I am Good Runnable");
            i++;
        }
    }
}
class customThread2 extends Thread{
    public  void run(){
        int i =0;
        while (i<300) {
            System.out.println("My thread is Running Runnable");
            System.out.println("thread run  Runnable");
            i++;
        }
    }
}
public class Multithreading {
    public static void main(String[] args) {
        customThread ct = new customThread();
        customThread2 ct2 = new customThread2();
        ct.start();
        ct2.start();
    }
}
