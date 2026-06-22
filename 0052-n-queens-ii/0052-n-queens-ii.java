class Solution {
    public int totalNQueens(int n) {
        boolean[] col=new boolean[n];
        boolean[] d1=new boolean[2*n];
        boolean[] d2=new boolean[2*n];
        return backtrack(0,n,col,d1,d2);
    }
    private int backtrack(int r,int n,boolean[] col,boolean[] d1,boolean[] d2){
        if(r==n)return 1;
        int count=0;
        for(int c=0;c<n;c++){
            if(col[c]||d1[r-c+n]||d2[r+c])continue;
            col[c]=d1[r-c+n]=d2[r+c]=true;
            count+=backtrack(r+1,n,col,d1,d2);
            col[c]=d1[r-c+n]=d2[r+c]=false;
        }
        return count;
    }
}