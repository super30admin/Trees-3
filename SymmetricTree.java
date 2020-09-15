class SymmetricTree {
    // Time Complexity:    O(n) - traverse every element
    // Space Complexity:   O(n) - n is the height of the tree, which is n in worstcase.
    public boolean isSymmetric(TreeNode root) {
        if(root == null)    return true;
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode){
// // Recursive
//         // 1. Check if the root is null
//         // 2. We will check for child nodes 
//         //         - both are null ==> RETURN true            OR
//         //         - one of them is null or not same ==> RETURN false     OR
//         //         - both have same value ==> check further below nodes 
//         // 3. From the third condition, we get 
//         //         - same values       AND
//         //         - left (SUBTREE) == right (SUBTREE)    AND
//         //         - right (SRUBTREE) == left (SUBTREE)
        
        if(leftNode == null && rightNode == null) return true;
        if(leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
        return (leftNode.val == rightNode.val) && isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
        
// ITERATIVE
        // 1. Check for the root is null
        // 2. Take the Queue - (BFS) for comparision
        // 3. Add left and right children to the queue
        // 4. WHile stack not empty, evaluate both the nodes added to queue.
        // 5. if not equal return false
        // 6. if equal but not null -> then further add the nodes to the queue.
            
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(leftNode);
        // queue.add(rightNode);
        
        // while(!queue.isEmpty()){
        //     TreeNode[] t = {queue.poll(), queue.poll()};
        //     if(t[0] == null && t[1] == null)    continue;
        //     if(t[0] == null || t[1] == null)    return false;
        //     if(t[0].val != t[1].val) return false;
        //     if(t[0].val == t[1].val){
        //         queue.add(t[0].left);
        //         queue.add(t[1].right);
        //         queue.add(t[0].right);
        //         queue.add(t[1].left);
        //     }
        // }
        // return true;
    }
}