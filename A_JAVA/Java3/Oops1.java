package Java3;

class Pen{
    //data
    String color;
    String type;
    String smoothness;
    int speed;

     //Constructer -Parametrized ,Non-parametrized and default 
     Pen(String smoothness, int speed){
        System.out.println("Firstly Constructer Call");
        this.smoothness=smoothness;
        this.speed=speed;
        System.out.println(this.speed);
    }

    //method(state)
    public void write(){
        System.out.println(this.color);
        System.out.println(this.type);
        System.out.println("Write something ");
        System.out.println("speed is called by method "+ this.speed);
    }
   
}


public class Oops1 {
    public static void main(String[] args) {
        Pen pen1=new Pen("better",10);
        pen1.color="blue";
        pen1.type="bolPen";
        System.out.println(pen1.color + " "+ pen1.type);
        pen1.write();
    }
}
