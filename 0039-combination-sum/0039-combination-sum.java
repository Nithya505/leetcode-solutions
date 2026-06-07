class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>res=new ArrayList<>();
        backtrack(nums,target,0,new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int[] c,int target,int idx,List<Integer>path,List<List<Integer>>res){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;

        }
        if(target<0)return;
        for(int i=idx;i<c.length;i++){
            path.add(c[i]);
            backtrack(c,target-c[i],i,path,res);
            path.remove(path.size()-1);
        }
        }

     

        }
    
