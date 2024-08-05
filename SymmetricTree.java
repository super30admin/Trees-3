// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    boolean flag = true;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();

    private void preOrder(TreeNode root){
        if(root == null) return;
        if(root.left == null || root.right == null) {
            list.add(null);
        }
        preOrder(root.left);
        list.add(root.val);
        preOrder(root.right);
    }
    private void postOrder(TreeNode root){
        if(root == null) return;
        if(root.left == null || root.right == null) {
            list2.add(null);
        }
        postOrder(root.right);
        //System.out.println(root.val);
        list2.add(root.val);
        postOrder(root.left);
    }
    public boolean isSymmetric(TreeNode root) {
        preOrder(root.left);
        postOrder(root.right);
        System.out.println(list);
        System.out.println(list2);
        int i=0;
        if(list.size() != list2.size()) return false;
        while(i<list.size()){
            if(list.get(i) != list2.get(i)) return false;
            i++;
        }
        return true;
    }
}
