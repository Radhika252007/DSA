class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            int a = 0, b = image[i].length-1;
            while(a<=b){
                int temp = 1^image[i][a];
                image[i][a] = 1^image[i][b];
                image[i][b] = temp;
                a++;
                b--;
            }
        }
        return image;
    }
}