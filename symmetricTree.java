// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

//using DFS
public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return helper(root.left,root.right);
}

private boolean helper(TreeNode left, TreeNode right){
    if(left == null && right ==null) return true;
    if(left == null || right == null || left.val != right.val){
        // isValid=false;
        return false;
    }
    
    return helper(left.left,right.right) && helper(left.right,right.left);
}

//using BFS
// Time Complexity :O(N)
// Space Complexity :O(2^H)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    
    //BFS 
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root.left);
    q.add(root.right);
    //matching 2 consecutive elements from queue
    while(!q.isEmpty()){
        TreeNode left = q.poll();
        TreeNode right = q.poll();
        if(left == null && right == null) continue;
        if(left == null || right == null || left.val != right.val) return false;

        //adding elements in specific order bnecause it is important while matching.
        q.add(left.left);
        q.add(right.right);
        q.add(left.right);
        q.add(right.left);
    }
    
    return true;
}