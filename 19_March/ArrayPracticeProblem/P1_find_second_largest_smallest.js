function getRandomThreeDigitNumber() {
    return Math.floor(100 + Math.random() * 900);
}
function secondLargest(arr) {
    let a1 = -Infinity, a3 = -Infinity;
    let a2 = Infinity, a4 = Infinity;

    for (let num of arr) {
        if (num > a1) {
            a3 = a1;
            a1 = num;
        } else if (num > a3 && num !== a1) {
            a3 = num;
        }

        if (num < a2) {
            a4 = a2;
            a2 = num;
        } else if (num < a4 && num !== a2) {
            a4 = num;
        }
    }

    return { secondLargest: a3, secondSmallest: a4 };
}

let randomNumbers = Array.from({ length: 10 }, getRandomThreeDigitNumber);

console.log("Generated Array:", randomNumbers);

let result = secondLargest(randomNumbers);

console.log("Second Largest:", result.secondLargest);
console.log("Second Smallest:", result.secondSmallest);