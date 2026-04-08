class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int[] s1freq=new int[26];
        int[] windowfreq=new int[26];
        for(int i=0;i<s1.length();i++){
            s1freq[s1.charAt(i)-'a']++;
            windowfreq[s2.charAt(i)-'a']++;

        }
        for(int i=s1.length();i<s2.length();i++){
            if(matches(s1freq,windowfreq))return true;
            windowfreq[s2.charAt(i)-'a']++;
            windowfreq[s2.charAt(i-s1.length())-'a']--;
        }
        
            return matches(s1freq,windowfreq);
        }
        private boolean matches(int[] a,int[] b){
            for(int i=0;i<26;i++){
                if(a[i]!=b[i])
                return false;
            }
        
        return true;
        
        
    }
}
