class Solution {
    HashMap<Integer,Integer> map;
    public List<Integer> countSmaller(int[] nums) {
        map = new HashMap<>();
        int[] index = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            index[i] = i;
        }
        mergeSort(nums,index,0,nums.length-1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(map.getOrDefault(i, 0));
        }

        return res;
    }
    public void mergeSort(int[] arr,int[] index, int l, int h){
        if(l >= h) return;
        int mid = l + (h - l) / 2;
        mergeSort(arr,index,l,mid);
        mergeSort(arr,index,mid+1,h);
        merge(arr,index,l,mid,h);
    }
    public void merge(int[] arr,int[] index, int l, int m, int h){
        int[] temp = new int[h - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;
        int smaller = 0;
        while(i<=m && j<=h){
            if(arr[index[i]] <= arr[index[j]]){
                int originalIndex = index[i];
                map.put(originalIndex,map.getOrDefault(originalIndex,0)+smaller);
                temp[k++] =index[i++];
            }
            else{
                temp[k++] = index[j++];
                smaller++;
            }
        }
        while(i<=m) {
            map.put(index[i], map.getOrDefault(index[i],0)+smaller);
            temp[k++] = index[i++];
        }
        while(j<=h) temp[k++] = index[j++];
        for(int n = 0;n<k;n++){
            index[l+n] = temp[n];
        }
    }

}