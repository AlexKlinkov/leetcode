class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0;
        int currentWaitingTime = 0;

        for (int i = 0; i < customers.length; i++) {
            int arrivalTime = customers[i][0];
            int cookTime = customers[i][1];

            int startCooking = Math.max(currentWaitingTime, arrivalTime);
            int completionTime = startCooking + cookTime;
            totalWaitingTime += completionTime - arrivalTime;

            currentWaitingTime = completionTime;

        }

        return totalWaitingTime / customers.length;
    }
}