class Solution {
    public String convertToTitle(int columnNumber) {
        String res = "";
        while(columnNumber != 0){
            columnNumber--;
            int ch = columnNumber % 26;
            res =  (char)(65+ch) + res;
            columnNumber = columnNumber / 26;
        }
        return res;
    }
}