class Solution {
    public int[] sortArray(int[] nums) {
        
        mergeSort(nums,0,nums.length-1,new int[nums.length]);
        HashMap<Integer,Integer>freq=new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        return nums;
    }
    private void mergeSort(int a[],int l,int r,int[] tmp){
        if(l>=r)return;
        int m=(l+r)/2;
        mergeSort(a,l,m,tmp);
        mergeSort(a,m+1,r,tmp);
        merge(a,l,m,r,tmp);
    }
    private void merge(int[] a,int l,int m,int r,int[] tmp){
        int i=l,j=m+1,k=l;
        while(i<=m&&j<=r){
            if(a[i]<=a[j])
                tmp[k++]=a[i++];
            else
                tmp[k++]=a[j++];    
            
        }
        while(i<=m){
            tmp[k++]=a[i++];

        }
        while(j<=r){
            tmp[k++]=a[j++];
        }
        for(int x=l;x<=r;x++)
         a[x]=tmp[x];
        
        
    }
}