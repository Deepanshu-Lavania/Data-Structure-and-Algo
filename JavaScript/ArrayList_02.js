//! Apprcu1 : 
class ArrayList02 {
    static reverse(array) {
        let left = 0;
        let right = array.length - 1;

        while (right > left) {
            // Using a temporary variable to swap elements
            let temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            left++;
            right--;
        }

        console.log(array);
    }

    static main() {
        const l = [];
        const list = [];

        l.push("Deepanshu");
        l.push(5);
        l.push(true);
        l.push(5);
        l.push(1); // add in last
        l.push(2);
        l.push(7);
        console.log(l);
        
        l.splice(2, 0, 100); // add 100 at index 2
        l[3] = 10; // set index 3 to 10
        console.log("LastIndex of element is : " + l.lastIndexOf(5));

        console.log("The size of array is : " + l.length);
        console.log("Order of Elements of array are : ");
        console.log(l);
        console.log();
        
        l.forEach(item => process.stdout.write(item + " "));
        console.log();
        console.log("l[l.length - 1] : " + l[l.length - 1]); // give last value of arrayList

        list.push(5);
        list.push(1); // add in last
        list.push(2);
        list.push(5);
        list.push(1); // add in last
        list.push(2);
        list.push(7);
        list.splice(2, 0, 100); // add 100 at index 2
        list[3] = 10; // set index 3 to 10
        console.log("ArrayList before reversing is :");
        console.log(list);
        console.log("Reverse arrayList is : ");
        ArrayList02.reverse(list); // function call

        // Inbuilt method for reverse
        list.reverse();
        console.log("Reversed List is using built-in method: ");
        console.log(list);

        // Sort an array
        list.sort((a, b) => a - b); // Sort in ascending order
        console.log("Ascending Order: " + list);
        list.sort((a, b) => b - a); // Sort in descending order
        console.log("Sorting in Descending Order: " + list);

        const stringList = [];
        stringList.push("Welcome");
        stringList.push("To");
        stringList.push("Adhyan");
        stringList.push("Academy");

        stringList.sort(); // Default sort for strings is ascending
        console.log("Ascending Order for strings is: " + stringList);
        stringList.sort((a, b) => b.localeCompare(a)); // Sort in descending order
        console.log("Sorting in Descending Order for strings is: " + stringList);
    }
}

// Call the main function to run the program
ArrayList02.main();

/* In JavaScript, the static keyword is used within class definitions to indicate that a method or property belongs to the class itself rather than to instances of the class

While static is not necessary for every class or method in JavaScript, it serves an important purpose when you need to create methods or properties that are associated with the class itself rather than any particular instance. */



//! Approch2 : 
class ArrayList02 {
    constructor() {
        this.items = []; // Initializing an array to hold items
    }

    // Instance method to add an element
    add(element) {
        this.items.push(element);
    }

    // Instance method to get an element at a specific index
    get(index) {
        return this.items[index];
    }

    // Instance method to set an element at a specific index
    set(index, element) {
        this.items[index] = element;
    }

    // Instance method to reverse the array
    reverse() {
        let left = 0;
        let right = this.items.length - 1;

        while (right > left) {
            let temp = this.items[right];
            this.items[right] = this.items[left];
            this.items[left] = temp;
            left++;
            right--;
        }
        console.log("Reversed List:", this.items);
    }

    // Instance method to display the list
    display() {
        console.log("Current List:", this.items);
    }

    // Static method to reverse an array without needing an instance
    static staticReverse(array) {
        let left = 0;
        let right = array.length - 1;

        while (right > left) {
            let temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            left++;
            right--;
        }
        console.log("Reversed List (Static):", array);
    }

    // Static method to create a new ArrayList02 instance with initial elements
    static createWithElements(...elements) {
        const newList = new ArrayList02();
        elements.forEach(element => newList.add(element));
        return newList;
    }
}

// Usage of instance methods
const arrayList = new ArrayList02();
arrayList.add("Deepanshu");
arrayList.add(5);
arrayList.add(true);
arrayList.display(); // Display current list

arrayList.set(1, 10); // Update index 1
console.log("Element at index 1:", arrayList.get(1)); // Get element at index 1

arrayList.reverse(); // Reverse the list
arrayList.display(); // Display reversed list

// Usage of static methods
const staticArray = [1, 2, 3, 4, 5];
ArrayList02.staticReverse(staticArray); // Using static method to reverse a static array

const newArrayList = ArrayList02.createWithElements(10, 20, 30); // Creating a new instance with elements
newArrayList.display(); // Display the new array list


//? Instance Methods:
//  Methods like add(), get(), set(), reverse(), and display() operate on instance-specific data.
//? Static Mehod 
/*1. staticReverse(array): This method reverses a given array without needing to create an instance of ArrayList02. It operates independently of instance data.
2. createWithElements(...elements): A factory method that creates a new instance of ArrayList02 and initializes it with the provided elements. */