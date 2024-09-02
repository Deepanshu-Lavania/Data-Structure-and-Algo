package A_JAVA.Java3;

//! Multilevel Inheritance
/* class Animal {
    String name;// data

    Animal(String name) {// constructer
        this.name = "Jacky";
    }

    public void bark() {
        System.out.println(this.name + " is barking on the peoples");
    }
}

class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }
    void eat() {
        System.out.println(name + " is eating the " + this.breed);
    }
}
class Puppy extends Dog{
    String bath;
    Puppy(String name, String breed, String bath){
        super(name, breed);
        this.bath=bath;
    }
    void play(){
        System.out.println(name +" is barking on peoples "+ "after eating the " + breed + " but he just  wants to play with them before "+ bath);
    }
}
 */


 //!Hirarchical Inheritance
 class Animal{
    public void eat(){
         System.out.println("Every animal eats the food");
    }
 }
 class Cow extends Animal{
    public void milk(){
        System.out.println("Most of Indians like cow's milk");
    }
 }
 class Dog extends Animal{
    public void puppy(){
        System.out.println("     Most of Indians like to bring out the Dogs");
    }
    public void eat(){
        System.out.println("     dog eats and it override the eat method  of animal class");
    }
 }
 class Cat extends Animal{
    public void response(){
        System.out.println("Cats react very fast when action is occurs on them");
        super.eat();
    }
 }
 

public class Inheritance {
    public static void main(String[] args) {
        
        /* Puppy puppy = new Puppy("Puppy","breeds","bathing");
        puppy.play();
        puppy.eat();
        puppy.bark(); */
        
         

        // Cow cow = new Cow();
        // Dog dog =new Dog();
        // Cat cat = new Cat();

        // cow.milk();
        // cow.eat();
        // dog.puppy();
        // dog.eat();
        // cat.response();
  


    }
}
