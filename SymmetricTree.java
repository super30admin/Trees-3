
// =============================== Recursive DFS =====================================
/**
Time complexity: O(N) where N number of nodes
Space complexity: Worst case where tree is linear, recursive stack space is O(N) where as average cases O(H) where H is height of the tree

Algorithm:
==========
1. Basic idea is to check if left subtree's left nodes are equal to right subtree's right nodes have same values and left's right vs right's left 
as well
2. If both are null, that means the nodes are still symmetric, if one of them is not then asymmetric.
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    
    private boolean helper(TreeNode root1, TreeNode root2) {
        if( root1 == null && root2 == null) return true;						// if both are null, symmetric
        if( root1 == null || root2 == null || root1.val != root2.val) return false; // if one of them is null or values not equal, asymmetric
        
        return helper(root1.left, root2.right) && helper(root1.right, root2.left); // recursively check symmetry in r1r2's right-left and left-right subtrees
    }
}

// =============================== Iterative DFS =====================================
/**
Time complexity: O(N) where N is number of nodes
Space: O(N)
Algorithm:
=========
1. Create a stack of pairs of treenodes to compare left and right subtrees. 
2. Pop each pair from stack and check if they are equal. 
3. If so, push left's left and right's right, left's right and right's left subtree nodes to stack.
4. If any of the conditions fail, return false. Else return true
 */
class Solution {
    class Pair {
        TreeNode root1;
        TreeNode root2;
        
        public Pair(TreeNode root1, TreeNode root2) {
            this.root1 = root1;
            this.root2 = root2;
        }
        
        public TreeNode getKey() {
            return this.root1;
        }
        
        public TreeNode getValue() {
            return this.root2;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;               // root is null
        
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root));           // stack of pairs < left of root1, right of root2
        
        while(!stack.isEmpty()) {
            Pair nodes = stack.pop();               // pop each pair from stack
            TreeNode root1 = nodes.root1;
            TreeNode root2 = nodes.root2;
            if(root1 != null || root2 != null) {    //If one of them is not null, check if both are not null or if one of them is, return false as it is asymmetric
                if(root1 != null && root2 != null && root1.val == root2.val) {
                    stack.push(new Pair(root1.left, root2.right));
                    stack.push(new Pair(root1.right, root2.left));
                }
                else {
                    return false;
                }
            }
        }
        return true;                            // Return true if all conditions are satisfied 
    }
}

// =============================== BFS =====================================
/**
Algorithm:
=========
1. Create a queue of pairs of treenodes to compare left and right subtrees. 
2. Pop each pair from stack and check if they are equal. 
3. If so, push left's left and right's right, left's right and right's left subtree nodes to stack.
4. If any of the conditions fail, return false. Else return true
 */
class Solution {
    class Pair {
        TreeNode root1;
        TreeNode root2;
        
        public Pair(TreeNode root1, TreeNode root2) {
            this.root1 = root1;
            this.root2 = root2;
        }
        
        public TreeNode getKey() {
            return this.root1;
        }
        
        public TreeNode getValue() {
            return this.root2;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;               // root is null
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, root));
        
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode root1 = p.getKey();
            TreeNode root2 = p.getValue();
    
            if( root1 != null || root2 != null) {
    
                if(root1 != null && root2 != null && root1.val == root2.val) {	// check if symmetry is satisfied by both the nodes
                    queue.add(new Pair(root1.left, root2.right)); 		// check symmetry on LR subtree
                    queue.add(new Pair(root1.right, root2.left));		// check symmetry on RL subtree
                }
                else
                    return false;
            }
        }
        return true;
    }
}