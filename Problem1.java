Time Complexity: O(n)
Space Complexity: O(h)
Ran successfully on leetcode?: yes

class Solution {
    int target;
    List<List<Integer>> output = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target = sum;
        preorder(root, 0, new ArrayList<Integer>());
        return output;
    }
    
    private void preorder(TreeNode root, int currSum, List<Integer> list){
        if(root == null) return;
        currSum = currSum + root.val;
        
        list.add(root.val);
        
        if(root.left == null && root.right == null){
            if(currSum == target){
                output.add(new ArrayList<Integer>(list));
            }
        } else {
            preorder(root.left, currSum, list);
            preorder(root.right, currSum, list);
        }
        
        list.remove(list.size() - 1);
        
    }
}
