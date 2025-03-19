function getPrimeFactors(n) {
    let factor = [];

    while (n % 2 === 0) {
        factor.push(2);
        n = Math.floor(n / 2);
    }

    for (let i = 3; i * i <= n; i += 2) {
        while (n % i === 0) {
            factor.push(i);
            n = Math.floor(n / i);
        }
    }

    if (n > 2) {
        factor.push(n);
    }

    return factor;
}

let num = 84;
let factors = getPrimeFactors(num);

console.log(`Prime Factors of ${num}:`, factors);