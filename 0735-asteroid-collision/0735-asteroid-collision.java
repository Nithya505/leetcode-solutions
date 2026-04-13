class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer>stack=new ArrayDeque<>();
        for(int asteroid:asteroids){
            boolean destroyed=false;
            while(!stack.isEmpty()&&asteroid<0&&stack.peekLast()>0){
                int top=stack.peekLast();
                if(top<-asteroid){
                    stack.pollLast();
                }else if(top==-asteroid){
                    stack.pollLast();
                    destroyed=true;
                    break;
                }else{
                    destroyed=true;
                    break;
                }
            }
            if(!destroyed){
                stack.addLast(asteroid);
            }
        }
        int[] result =new int[stack.size()];
        int i=0;
        for(int val:stack)
        result[i++]=val;
        return result;
        
    }
}