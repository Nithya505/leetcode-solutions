class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=getmax(piles);
        int ans=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(caneatall(piles,mid,h)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
        
    }
    private int getmax(int[] piles){
        int max=0;
        for(int pile:piles){
            if(pile>max){
                max=pile;
            }
        }
        return max;
        
    }
    
    private boolean caneatall(int[] piles,int k,int h){
        long totalhours=0;
        for(int pile:piles){
            totalhours+=(pile+k-1)/k;
        }
        return totalhours<=h;
    } 
    
    
}
