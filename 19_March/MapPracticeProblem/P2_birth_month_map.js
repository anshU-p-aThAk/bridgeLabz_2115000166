function generateBirthdays(count) {
    let hm = new Map();

    for (let i = 1; i <= 12; i++) {
        hm.set(i, []);
    }

    for (let i = 1; i <= count; i++) {
        let month = Math.floor(1 + Math.random() * 12);
        hm.get(month).push(i);
    }

    return hm;
}

let birthdays = generateBirthdays(50);

console.log("Birthdays grouped by month:");
for (let [month, individuals] of birthdays.entries()) {
    console.log(`Month ${month}:`, individuals);
}