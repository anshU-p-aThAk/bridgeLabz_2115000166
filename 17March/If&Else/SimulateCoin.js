function simulateCoinFlip() {
  let randomNum = Math.random();

  if (randomNum < 0.5) {
    console.log("Heads");
  } else {
    console.log("Tails");
  }
}

simulateCoinFlip();
