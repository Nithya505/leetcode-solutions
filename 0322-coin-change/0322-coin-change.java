class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1)return 0;
        int[] mincoinsdp=new int[amount+1];
        for(int i=1;i<=amount;i++){
            mincoinsdp[i]=Integer.MAX_VALUE;
            for(int coin:coins){
                if(coin<=i&&mincoinsdp[i-coin]!=Integer.MAX_VALUE)
                mincoinsdp[i]=Math.min(mincoinsdp[i],1+mincoinsdp[i-coin]);

            }
            if(mincoinsdp[amount]==Integer.MAX_VALUE)
            return -1;
            
        }

        
    return mincoinsdp[amount];
    }
}
