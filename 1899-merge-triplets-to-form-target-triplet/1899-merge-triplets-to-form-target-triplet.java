class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] maxvalues=new int[3];
        for(int[] triplet:triplets){
            if(triplet[0]<=target[0]&&triplet[1]<=target[1]&&triplet[2]<=target[2]){
                maxvalues[0]=Math.max(maxvalues[0],triplet[0]);
                maxvalues[1]=Math.max(maxvalues[1],triplet[1]);
                maxvalues[2]=Math.max(maxvalues[2],triplet[2]);
            }
        }
        return maxvalues[0]==target[0]&&maxvalues[1]==target[1]&&maxvalues[2]==target[2];
        
    }
}
