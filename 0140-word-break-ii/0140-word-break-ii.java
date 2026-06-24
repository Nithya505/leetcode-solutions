class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String>set=new HashSet<>(wordDict);
        Map<Integer,List<String>>memo=new HashMap<>();
        return backtrack(s,0,set,memo);
    }
    private List<String> backtrack(String s,int start,Set<String>set,Map<Integer,List<String>>memo){
        if(memo.containsKey(start))return memo.get(start);
        List<String>res=new ArrayList<>();
        if(start==s.length()){
            res.add("");
            return res;
        }
        for(int end=start+1;end<=s.length();end++){
            String word=s.substring(start,end);
            if(set.contains(word)){
                List<String>subList=backtrack(s,end,set,memo);
                for(String sub:subList){
                    if(sub.isEmpty())res.add(word);
                    else res.add(word+" "+sub);
                }
            }
        }
        
        memo.put(start,res);
        return res;
        }
    }
    