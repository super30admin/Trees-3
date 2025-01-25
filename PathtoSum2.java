class PathtoSum2 {
    List<List<Integer>> result = new ArrayList<>();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        target = targetSum;
        recurseSumEqualsTarget(root, 0, new ArrayList<>());
        return result;
    }

    private void recurseSumEqualsTarget(TreeNode root, int currentSum, List<Integer> list){
        if(root == null){
            return;
        }
        currentSum+=root.val;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(currentSum == target){
                result.add(new ArrayList<>(list));
            }
            // return;
        }

        recurseSumEqualsTarget(root.left, currentSum, list);
        recurseSumEqualsTarget(root.right, currentSum, list);
        list.remove(list.size()-1);
    }
}
