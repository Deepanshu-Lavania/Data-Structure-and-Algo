package Java6;

class Mythr extends Thread{
    public Mythr(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(this.getName() + " : " + i);
        }
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        Mythr t1 = new Mythr("Deepanshu afdsagfgsfdg fs dg fds gf dg dfg");
        Mythr t2 = new Mythr("Singh");
        Mythr t3 = new Mythr("Lavania");
        Mythr t4 = new Mythr("three_name   ");
        t1.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
  
    }
}