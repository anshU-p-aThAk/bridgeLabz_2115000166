class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0, surplus = 0, startIndex = 0;

        for (int i = 0; i < n; i++) {
            int balance = petrol[i] - distance[i];
            totalSurplus += balance;
            surplus += balance;

            if (surplus < 0) {
                startIndex = i + 1;
                surplus = 0;
            }
        }

        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = { 4, 6, 7, 4 };
        int[] distance = { 6, 5, 3, 5 };

        int start = findStartingPoint(petrol, distance);
        System.out.println("Starting Pump Index: " + start);
    }
}
