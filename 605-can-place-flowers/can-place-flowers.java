class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0 ;i< flowerbed.length;i++){
            if(n==0) return true;
            int left = (i==0) ? 0 : flowerbed[i - 1];
            int right = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
            if(flowerbed[i] != 1 && right == 0 && left == 0){
                flowerbed[i] = 1;
                n--;
            }
        }
        if(n == 0) return true;
        return false;

    }
}