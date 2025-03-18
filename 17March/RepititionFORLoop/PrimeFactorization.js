function primeFactors(N) {
  let factors = [];

  while (N % 2 === 0) {
    factors.push(2);
    N = N / 2;
  }

  for (let i = 3; i * i <= N; i += 2) {
    while (N % i === 0) {
      factors.push(i);
      N = N / i;
    }
  }

  if (N > 2) {
    factors.push(N);
  }

  return factors;
}

let N = prompt("Enter a number: ");
console.log(`Prime factors of ${N} are: ${primeFactors(N).join(", ")}`);
