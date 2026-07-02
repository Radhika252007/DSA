import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0;i<nums.length-1;i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j = i+1;j<nums.length;j++){
                int sum = -(nums[i] + nums[j]);
                if(hashset.contains(sum)){
                    List<Integer> list = Arrays.asList(nums[i],nums[j],sum);
                    Collections.sort(list);
                    set.add(list);
                }
                hashset.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }
}