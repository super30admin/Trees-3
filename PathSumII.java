public class PathSumII {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        inorder(root, targetSum, 0, new ArrayList<>());
        return result;
    }
    
    // TC is O(n)
    // SC is O(h)
    private void inorder(TreeNode root, int target, int curr, List<Integer> list){
        // base
        if(root == null) return;
        
        // left
        curr += root.val;
        list.add(root.val);
        inorder(root.left, target, curr, list);
        if(root.left == null && root.right == null && curr == target){
            System.out.println(list);
            result.add(new ArrayList<>(list));
        }
        inorder(root.right, target, curr, list);
        list.remove(list.size()-1);
    }
}
