package A_JAVA.Java3.Revision;

public class AccessModifier {
    static class Vehicle {
        public int time = 2;
        public String name = "Chirag";
        String carName;
        int speed;

        Vehicle(String carName, int speeed) {
            this.carName = carName;
            this.speed = speeed;
        }

        void distance(int time, String name) {
            int distance = this.speed * time;
            System.out.println(name + " drove the car upto " + distance + " km daily");
        }
    }

    public static class Employee {
        // Instance variables with different access modifiers

        public int id; // Accessible anywhere
        private String name; // Accessible only within the Employee class
        protected double salary; // Accessible within the same package and subclasses
        int age; // Default (package-private), accessible within the same package

        // Constructor
        public Employee(int id, String name, double salary, int age) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.age = age;
        }

        // Getter for private variable 'name'
        public String getName() {
            setName("Deepanshu");
            return name; // Provide controlled access to 'name'
        }

        // Setter for private variable 'name'
        private void setName(String name) {
            this.name = name;
        }
        // public void setName(String name) {
        //     this.name = name;
        // }
    }

    public static void main(String[] args) {
        Vehicle car = new Vehicle("toyota", 15);
        car.distance(car.time, car.name);

        System.out.println("<=========Instace variables for access modifiers=========>");
        Employee emp = new Employee(1, "John Doe", 50000, 30);
        // Access public variable directly
        System.out.println("ID: " + emp.id); // Works

        // Access private variable using getter
        System.out.println("Name: " + emp.getName()); // Works (using getter)

        // Access protected variable (works if Main is in the same package)
        System.out.println("Salary: " + emp.salary); // Works within the same package or subclass

        // Access package-private variable (works if Main is in the same package)
        System.out.println("Age: " + emp.age); // Works if Main is in the same package
    }
}
