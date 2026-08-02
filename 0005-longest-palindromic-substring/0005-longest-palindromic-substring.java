class Solution {
    public String longestPalindrome(String str) {
        if(str.length()<=1)return str;
        String lps="";
        for(int i=1;i<str.length();i++){
            int low=i;
            int high=i;
            while(str.charAt(low)==str.charAt(high)){
                low--;
                high++;
                if(low==-1||high==str.length())
                break;
            }
            String palindrome=str.substring(low+1,high);
            if(palindrome.length()>lps.length()){
                lps=palindrome;
            }
            low=i-1;
            high=i;
            while(str.charAt(low)==str.charAt(high)){
                low--;
                high++;
                if(low==-1||high==str.length())
                break;
            }
             palindrome=str.substring(low+1,high);
            if(palindrome.length()>lps.length()){
                lps=palindrome;
            }
            



        }

      return lps;  
    }
}
