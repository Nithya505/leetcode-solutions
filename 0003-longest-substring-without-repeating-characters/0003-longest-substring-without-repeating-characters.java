class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastseen=new int[128];
        int maxlen=0;
        int start=0;
        for(int end=0;end<s.length();end++){
            char c=s.charAt(end);
            start=Math.max(start,lastseen[c]);
            maxlen=Math.max(maxlen,end-start+1);
            lastseen[c]=end+1;

        }
        return maxlen;
        
        
    }
}
