class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int totalnodes = edges.length;
        int res[] =new int[2];
        DisjointSet dsu = new DisjointSet(totalnodes);
        for (int[] edge : edges) {
            if (!dsu.unionbysize(edge[0] - 1, edge[1] - 1)) {
                res = edge;
            }
        }
        return res;
    }
}
public class DisjointSet {
    int parent[];
    int size[];
    DisjointSet(int nodes) {
        this.parent = new int[nodes];
        this.size = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    public int findrootparent(int node){
        if(node==parent[node]){
            return node;
        }
        parent[node]=findrootparent(parent[node]);
        return parent[node];
    }
    public boolean unionbysize(int node1,int node2){
        int rootparent1=findrootparent(node1);
        int rootparent2=findrootparent(node2);
        if(rootparent1==rootparent2){
            return false;
        }
        if(size[rootparent1]<size[rootparent2]){
            parent[rootparent1]=rootparent2;
            size[rootparent2]+=size[rootparent1];
        }else{
             parent[rootparent2]=rootparent1;
            size[rootparent1]+=size[rootparent2];

        }
        return true;
    }
}
