class Solution {
    public String simplifyPath(String path) {
        String[] parts=path.split("/");
        Stack<String>stack=new Stack<>();
        for(String dir:parts){
            if(dir.equals("")||dir.equals(".")){
                continue;
            }else if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                }else{
                    stack.push(dir);
                }
            }
           
    return "/"+String.join("/",stack);
        
        
    }
}