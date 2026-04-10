class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        int[] tfreq=new int[128];
        for(char ch:t.toCharArray()){
            tfreq[ch]++;

        }
        int[] windowfreq=new int[128];
        int required=t.length();
        int left=0,right=0,minlen=Integer.MAX_VALUE;
        int start=0;
        while(right<s.length()){
            char rchar=s.charAt(right);
            if(tfreq[rchar]>0){
                windowfreq[rchar]++;
                if(windowfreq[rchar]<=tfreq[rchar]){
                    required--;
                }
            }
            while(required==0){
                if(right-left+1<=minlen){
                    minlen=right-left+1;
                    start=left;
                }
                char lchar=s.charAt(left);
                if(tfreq[lchar]>0){
                    windowfreq[lchar]--;
                    if(windowfreq[lchar]<tfreq[lchar]){
                        required++;
                    }

                }
                left++;

            }
            right++;
        }
        return minlen==Integer.MAX_VALUE?"":s.substring(start,start+minlen);
    }
}
