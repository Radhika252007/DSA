class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Point[] res = new Point[points.length];
        for(int i = 0;i<points.length;i++){
            double xDist = Math.pow(points[i][0] - 0, 2);
            double yDist = Math.pow(points[i][1] - 0, 2);
            double distance = Math.sqrt(xDist + yDist);
            res[i] = new Point(points[i][0], points[i][1], distance);
        }
        Arrays.sort(res,Comparator.comparingDouble(a -> a.dist));
        int[][] ans = new int[k][2];
        for(int i = 0;i<k;i++){
            ans[i] = new int[]{res[i].x, res[i].y};
        }
        return ans;
    }
}
class Point{
    int x;
    int y;
    double dist;
    Point(int x, int y, double dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}