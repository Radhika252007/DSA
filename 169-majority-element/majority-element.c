int majorityElement(int* nums, int numsSize) {
    int freq = 1, ans =0;
    for(int i=0;i<numsSize;i++){
        if(freq==1){
            ans = nums[i];
        }
        if(ans==nums[i])freq++;
        else freq--;
    }
    return ans;
}