
/*//? array.splice(startIndex, deleteCount, item1, item2, ...);
startIndex: The index at which to start making changes (insertion or removal).
deleteCount: The number of elements to remove from the array starting at startIndex. If it's 0, no elements will be removed.
item1, item2, ...: The elements to be added at startIndex. */

//? The `indexOf` method finds the index of a value. 

//?JavaScript uses .push() to add elements to an array, and .splice() for inserting elements at a specific index.
//? The reversing function is quite similar, but JavaScript arrays come with an inbuilt .reverse() method for reversing arrays.


// let l = []; //? Dynamic array in JavaScript

//! Sorting 
/* //? Sort array in descending order
list.sort((a, b) => b - a);
console.log("Sorting in descending order: " + list); */
//* WORKING:
/* // Comparator function for ascending order
function list(a, b) {
    return a - b; // Ascending order: smaller values first
} */

/* //? Sort string array in descending order
stringList.sort((a, b) => b.localeCompare(a));
console.log("Sorting in descending order for string is: " + stringList); */


//? MIN and MAX VALUE
//* Note : In JavaScript, Number.MIN_VALUE represents the smallest positive number (closest to 0), not the smallest negative number. It is approximately 5e-324.
// let FirstMax = Number.MIN_SAFE_INTEGER; // Initialized to very small value
// let FirstMin = Number.MAX_VALUE; // Initialized to a very large value (not typical for this scenario)


//! How we declare array 
/* //?steps to declare array
step1 :  Hardcoded Arrays: let arr = [1, 2, 3];
step2 :  User Input via prompt(): Collects input in a browser environment.
step3 :  HTML Form Inputs: Collect input through form elements, then convert it into an array. */


/* let arr = [];
let numElements = prompt("How many elements do you want to enter?");
numElements = parseInt(numElements);

for (let i = 0; i < numElements; i++) {
    let value = prompt(`Enter value ${i + 1}:`);
    arr.push(parseInt(value)); //? Converting the input to a number and adding it to the array
}
console.log(arr); */


//? split(",") : means if , see then split and remove , automatically and After split(","), the commas are removed, and the result is an array of string elements (like ['1', '2', '3']).
//?   join(", ") : to separte or join by , and After join(", "), the array [1, 2, 3, 4, 5] is converted back to a string, with each element separated by , .
//?  Number :This is a function that converts a string into a number. It is used to convert each string element from the array into a numeric value.
//*example :
/*  let str = "123";
let num = Number(str); // 123 (number) */

/* let arr = ["1", "2", "3"];
let numArr = arr.map(Number); // [1, 2, 3] (now all elements are numbers) */


{/* <body>
    <h3>Enter numbers separated by commas:</h3>
    <input type="text" id="arrayInput" placeholder="e.g., 1,2,3,4" />
    <button onclick="getArray()">Submit</button>

    <h3>Array Output:</h3>
    <p id="output"></p>

    <script>
      function getArray() {
        // Get input from the text field
        let input = document.getElementById("arrayInput").value;

        // Split the input string by commas and convert each element to a number
        let arr = input.split(",").map(Number);

        // Display the array on the webpage
        document.getElementById("output").innerText =
          "Array: [" + arr.join(", ") + "]";
      }
    </script>
</body> */}

//? In JavaScript, uninitialized array elements are set to "undefined".
/* Array Creation Method	Resulting Array	Accessing Element
let arr = new Array(5);	[ <5 empty items> ]	===> arr[0] returns undefined
let arr = [];  ===>	[]
let arr = [1, 2, 3];	===> [1, 2, 3]	 */


