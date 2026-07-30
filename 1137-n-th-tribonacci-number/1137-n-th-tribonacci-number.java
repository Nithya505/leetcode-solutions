class Solution {
    public int tribonacci(int n) {
        if(n<=1)return n;
        int[] map=new int[n+1];
        map[0]=0;
        map[1]=1;
        map[2]=1;
        for(int i=3;i<=n;i+=1){
            map[i]=map[i-1]+map[i-2]+map[i-3];
        }
        return map[n];
        
    }
}