class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] dp = new int[nums.length];
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {

            // Remove indices outside the allowed window
            while (!dq.isEmpty() && dq.getFirst() < i - k) {
                dq.removeFirst();
            }

            // Extend the best previous subsequence if beneficial
            dp[i] = nums[i];
            if (!dq.isEmpty()) {
                dp[i] += Math.max(0, dp[dq.getFirst()]);
            }

            maxSum = Math.max(maxSum, dp[i]);

            // Maintain decreasing DP values
            while (!dq.isEmpty() &&
                   dp[dq.getLast()] <= dp[i]) {
                dq.removeLast();
            }

            // Only positive DP values can improve future sums
            if (dp[i] > 0) {
                dq.addLast(i);
            }
        }

        return maxSum;
    }
}