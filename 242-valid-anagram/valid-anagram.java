class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        String res1 = new String(s1);
        String res2 = new String(s2);
        return res1.equals(res2);
    }
}