class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer>stack=new Stack<>();
        for(String op:operations){
            if(op.equals("C")){
                stack.pop();

            }else if(op.equals("D")){
                stack.push(2*stack.peek());
            }else if(op.equals("+")){
                int top=stack.pop();
                int newtop=top+stack.peek();
                stack.push(top);
                stack.push(newtop);
            }else{
                stack.push(Integer.parseInt(op));
            }
        }
        int total=0;
        for(int score:stack){
            total+=score;
        }
        return total;
        
    }
}