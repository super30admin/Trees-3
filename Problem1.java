class Problem1 {
    List<List<Integer>> result =   new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum,new ArrayList<>(),0);
        return result;
    }
    private void helper(TreeNode root, int targetSum,List<Integer> path,int curr){
        if(root==null) return;
        List<Integer> li = new ArrayList<>(path);
        int rootVal = root.val;
        curr+=rootVal;

        li.add(rootVal);
        if(root.left==null && root.right==null){
            if(curr==targetSum){
                result.add(li);
                return;
            }
        }
        helper(root.left,targetSum,li,curr);
        helper(root.right,targetSum,li,curr);



    }
}