class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        String vowels = "aeiouAEIOU";
        while(i<j){
            while(i<s.length() && !vowels.contains(arr[i]+"")) i++;
            while(j>= 0 && !vowels.contains(arr[j]+"")) j--;
            if(i<j){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}