function findRepeatedDigitNumbers(rangeStart, rangeEnd) {
    let arr = [];

    for (let num = rangeStart; num <= rangeEnd; num++) {
        let strNum = num.toString();
        if (strNum.length === 2 && strNum[0] === strNum[1]) {
            arr.push(num);
        }
    }

    return arr;
}

let repeatedDigits = findRepeatedDigitNumbers(10, 99);

console.log("Numbers with repeated digits:", repeatedDigits);