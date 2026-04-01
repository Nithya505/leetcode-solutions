class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int maxwater=0;
        while(left<right){
            int width=right-left;
            int minheight=Math.min(heights[left],heights[right]);
            int area=width*minheight;
            maxwater=Math.max(maxwater,area);
            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }        }
            
        
        
    return maxwater;    
    }
}
