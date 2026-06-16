class Solution {
    public List<String> letterCombinations(String d) {
        List<String>r=new ArrayList<>();
        int n=d.length();
        if(n==0)return r;
        String[] m=new String[]{
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        char[] p=new char[n];
        bt(d,0,p,r,m);
        return r;
    }
    private void bt(String d,int i,char[] p,List<String>r,String[] m){
        if(i==d.length()){
            r.add(new String(p));
            return;
        }
        String s=m[d.charAt(i)-'0'];
        for(int k=0;k<s.length();k++){
            p[i]=s.charAt(k);
            bt(d,i+1,p,r,m);
        }
    }
}
