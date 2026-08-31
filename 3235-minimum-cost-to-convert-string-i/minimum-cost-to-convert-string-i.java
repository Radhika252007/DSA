class Solution {
    public long minimumCost(String source, String target,
                            char[] original, char[] changed, int[] cost) {

        long[][] dist = new long[26][26];

        // Initially, everything is unreachable
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }

        // Direct conversion costs
        for (int i = 0; i < original.length; i++) {
            int s = original[i] - 'a';
            int d = changed[i] - 'a';

            dist[s][d] = Math.min(dist[s][d], cost[i]);
        }

        // Floyd-Warshall
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {

                    if (dist[i][k] != Long.MAX_VALUE &&
                        dist[k][j] != Long.MAX_VALUE) {

                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }

        // Calculate total conversion cost
        long total = 0;

        for (int i = 0; i < source.length(); i++) {

            int s = source.charAt(i) - 'a';
            int d = target.charAt(i) - 'a';

            if (dist[s][d] == Long.MAX_VALUE) {
                return -1;
            }

            total += dist[s][d];
        }

        return total;
    }
}