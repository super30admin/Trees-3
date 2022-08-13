//TC:O(n)
//SC:O(h)

class Solution {
    public boolean isSymmetric(TreeNode root) {
      
        //consider left subtree as tree and right subtree as another tree and perform same tree check
     return   helper(root, root);

    }
    
    private boolean helper(TreeNode leftTree, TreeNode rightTree)

    {
        //comparing if both root null then true
       if(leftTree==null && rightTree==null){
           return true;
       }
        
        //comparing if any one root null then return false
    
    if(leftTree==null || rightTree ==null){
        return false;
    }
    
            //if both root value are same check the leftTrees left with right subtree's left
        if(leftTree.val == rightTree.val){
          boolean left = helper(leftTree.left, rightTree.right);
            //check the leftTrees right with right subtree's left
          boolean right = helper(leftTree.right, rightTree.left);
            
            //return boolean value of both trees
            return left&& right;
        }
    
    return false;
    
}}

/*
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}*/