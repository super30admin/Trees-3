// Time Complexity : O(N) all tree nodes are visisted
// Space Complexity : O(N) height of tree in worst case will be N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I knew the solution from beforehand.


// Your code here along with comments explaining your approach
//Symmteric tree is a mirror tree, where right side of one tree is equivalent to left side of the other.
//Used recursion.


class Solution {
    public boolean isSymmetric(TreeNode root) {        
        return isMirror(root,root);
    }
    
    private boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}



//Iterative solution using queue
// Time Complexity : O(N) all tree nodes are visisted
// Space Complexity : O(N) number of nodes that will get inserted in queue in worst case is N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I knew the solution from beforehand.


class Solution {
    public boolean isSymmetric(TreeNode root) {

    	//declare queue to add elements to it
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        
        //loop to pop and compare elements and add neww elements
        while(!q.isEmpty()){
            TreeNode p1 = q.poll();
            TreeNode p2 = q.poll();
            
            //mirror check logic
            if(p1 == null && p2 == null) continue;
            if(p1 == null || p2 == null) return false;
            if(p1.val != p2.val) return false;
            
            //add elements alternatively for correct comparison
            q.add(p1.left);
            q.add(p2.right);
            q.add(p1.right);
            q.add(p2.left);
            
        }
        
        return true;
    }
}