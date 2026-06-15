class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        backtrack(0,s,new ArrayList<>(),res);
        return res;
        }
       private void backtrack(int start,String s,List<String>path,List<List<String>>res){
        if(start==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(ispalindrome(s,start,end)){
                path.add(s.substring(start,end+1));
                backtrack(end+1,s,path,res);
                path.remove(path.size()-1);
            }
        }
       }
       private boolean ispalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))return false;
            l++;
            r--; 
        }
        return true;
       }
}
