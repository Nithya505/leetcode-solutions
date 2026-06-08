class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int[] arr,int target,int start,List<Integer>temp,List<List<Integer>>res){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(i>start&&arr[i]==arr[i-1])continue;
            if(arr[i]>target)break;
            temp.add(arr[i]);
            backtrack(arr,target-arr[i],i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }

}
