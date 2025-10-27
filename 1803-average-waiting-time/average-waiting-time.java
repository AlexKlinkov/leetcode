class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0;
        int startTimeForCooking = 0;

        for (int[] customer: customers) {
            int arriveTime = customer[0];
            int cookingTime = customer[1];
            // when the chef idles or when the customer arrived
            int startCookingTime = Math.max(startTimeForCooking, arriveTime);
            int completionTime = startCookingTime + cookingTime;
            totalWaitingTime += completionTime - arriveTime;

            startTimeForCooking = completionTime; // refresh start cooking time
        }
        return totalWaitingTime / customers.length;
    }
}