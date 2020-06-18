Ran in Leet Code - Yes, but submit failed for [1,-2,-3,1,3,-2,null,-1],2
Time Complexity-o(n*h)
space complexity=o(n)

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return pathsTotalToSum(root, sum);
    }
    
    List<List<Integer>> resultPaths = new ArrayList<>();
    List<List<Integer>>  pathsTotalToSum(TreeNode node, int sum){
        preOrderTraversePath( node, 0, new ArrayList<Integer>(), sum);
        return resultPaths;
    }
    
    void preOrderTraversePath(TreeNode node, int currSum,ArrayList<Integer> traversedList,int sum){
        if(node==null) return;
        
        currSum = currSum+node.val;
        traversedList.add(node.val);
        if(node.left==null && node.right==null){
            if(currSum==sum){
                resultPaths.add(new ArrayList<Integer>(traversedList));
            }
        }
        preOrderTraversePath( node.left, currSum,traversedList, sum);
        preOrderTraversePath( node.right, currSum,traversedList, sum);
        traversedList.remove((Integer)node.val);
        
    }
}
