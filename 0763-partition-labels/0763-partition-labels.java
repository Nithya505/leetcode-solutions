class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int startindex = i;
            int endindex = s.lastIndexOf(s.charAt(startindex));
            for ( int j = startindex + 1; j <= endindex - 1; j++) {
                int lastindexofnextchar = s.lastIndexOf(s.charAt(j));
                if (lastindexofnextchar > endindex) {
                    endindex = lastindexofnextchar;
                }
            }
            partitions.add(endindex - startindex + 1);
            i = endindex ;
        }
        return partitions;
    }
}
