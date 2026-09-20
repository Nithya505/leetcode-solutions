class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas=0,totalcost=0;
        for(int i=0;i<gas.length;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
        }
        if(totalgas<totalcost){
            return -1;
        }
        int currentgas=0,startindex=0;
        for(int i=0;i<gas.length;i++){
            currentgas+=gas[i]-cost[i];
            if(currentgas<0){
                startindex=i+1;
                currentgas=0;
            }
        }
        return startindex;
        
    }
}
