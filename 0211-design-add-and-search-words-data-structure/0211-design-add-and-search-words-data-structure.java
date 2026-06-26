class WordDictionary {
    class TrieNode{
        TrieNode[] children;
        boolean isend;
        TrieNode(){
            children=new TrieNode[26];
            isend=false;
        }
    }
    private TrieNode root;

    public WordDictionary() {
        root=new TrieNode();

    }

    public void addWord(String word) {
        TrieNode node=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(node.children[idx]==null){
                node.children[idx]=new TrieNode();
            }
            node=node.children[idx];
        }
        node.isend=true;

    }

    public boolean search(String word) {
        return dfssearch(word,0,root);
    }
    private boolean dfssearch(String word,int i,TrieNode node){
        if(i==word.length()){
            return node.isend;
        }
        char c=word.charAt(i);
        if(c=='.'){
            for(int j=0;j<26;j++){
                if(node.children[j]!=null&&dfssearch(word,i+1,node.children[j])){
                    return true;
                }
            }
            return false;
        }else{
            int idx=c-'a';
            if(node.children[idx]==null)return false;
            return dfssearch(word,i+1,node.children[idx]);
        }

    }
}
