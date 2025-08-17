class Solution {
    public List<String> letterCombinations(String digits) {
       
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        return phonePad("",digits);
    }
    public ArrayList<String> phonePad(String p, String up){
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char digit = up.charAt(0);
        String letters = map.get(digit);
        ArrayList<String> ans = new ArrayList<>();
        int j = 0;
        for(int i = 0; i<letters.length();i++){
            ans.addAll(phonePad(p+letters.charAt(i),up.substring(1)));
        }
        return ans;

    }
}