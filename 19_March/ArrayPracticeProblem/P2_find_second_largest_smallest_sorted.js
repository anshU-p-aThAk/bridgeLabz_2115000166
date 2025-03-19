function getRandomThreeDigitNumber() {
    return Math.floor(100 + Math.random() * 900);
}
function secondLargestSort(arr) {
    arr.sort((a, b) => a - b);
    let secondSmallest = arr[1];
    let secondLargest = arr[arr.length - 2];

    return { secondLargest, secondSmallest };
}

let num = Array.from({ length: 10 }, getRandomThreeDigitNumber);
console.log("Generated Array:", num);
let ans = secondLargestSort(num);

console.log("Sorted Array:", num);
console.log("Second Largest:", ans.secondLargest);
console.log("Second Smallest:", ans.secondSmallest);