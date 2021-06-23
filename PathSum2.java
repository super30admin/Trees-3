class PathSum2{
    // Time - O(n^2) -  creating new array for every node
    // Space - O(n)
     List<List<Integer>> result;
     int target;
     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         target = targetSum;
         result = new ArrayList<>();
         helper(root, 0, new ArrayList<>());
         return result;
     }

     public void helper(TreeNode root, int curSum, List<Integer> path){
         if(root == null) return;
         curSum = curSum + root.val;
         path.add(root.val);

         helper(root.left, curSum, new ArrayList<>(path)); //requires new array for every node

         helper(root.right, curSum, new ArrayList<>(path));
         if(root.left== null && root.right==null && curSum == target){ //this condition can be put anywhere pre/in/post order
             result.add(path);
         }
     }


    //optimized solution - bcaktracking
    // Time - O(n)
    // Space - O(n)
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        result = new ArrayList<>();
        helper(root, 0, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, int curSum, List<Integer> path){
        if(root == null) return;
        curSum = curSum + root.val;
        path.add(root.val);

        helper(root.left, curSum, path);

        helper(root.right, curSum, path);
        if(root.left== null && root.right==null && curSum == target){
            result.add(new ArrayList<>(path));
        }
        path.remove(path.size()-1);
    }
}