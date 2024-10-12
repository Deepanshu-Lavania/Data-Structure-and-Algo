
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