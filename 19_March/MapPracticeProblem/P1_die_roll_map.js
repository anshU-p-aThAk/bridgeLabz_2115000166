function rollDie() {
    return Math.floor(1 + Math.random() * 6);
}

function rollMaxReached() {
    let hm = new Map();
    let maxCount = 10;

    for (let i = 1; i <= 6; i++) {
        hm.set(i, 0);
    }

    while (true) {
        let roll = rollDie();
        hm.set(roll, hm.get(roll) + 1);

        if (hm.get(roll) === maxCount) {
            break;
        }
    }

    let maxRolled = [...hm.entries()].reduce((a, b) => (a[1] > b[1] ? a : b));
    let minRolled = [...hm.entries()].reduce((a, b) => (a[1] < b[1] ? a : b));

    return { hm, maxRolled, minRolled };
}

let ans = rollMaxReached();

console.log("Die Roll Counts:", Object.fromEntries(ans.hm));
console.log("Max Rolled:", ans.maxRolled);
console.log("Min Rolled:", ans.minRolled);