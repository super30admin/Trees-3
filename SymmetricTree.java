public class SymmetricTree {


    /*
    TC : O(N) where N is the number of nodes in the tree as we visit all the nodes
    SC : O(LogN) for the recursive stack
     */

    /**
     * Here we simply travers down the tree by calling left and right alternatively as we want to check whether the subtrees are mirror images of each other
     * and we use conditions like if either of them is null or the value doesnt match then return false
     */
    public boolean isSymmetric_using_recursion(TreeNode root) {

        return helper(root.left, root.right);

    }

    public boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        else if (node1 != null && node2 != null && node1.val != node2.val)
            return false;

        else if (node1 != null && node2 == null)
            return false;

        else if (node2 != null && node1 == null)
            return false;

        else
            return helper(node1.left, node2.right) && helper(node1.right, node2.left);


    }

    /*
    TC : O(N)
    SC : O(N)
     */

    /*
    The approach is simple, we add nodes in the order we want to compare them.
    The only catch is to add the root node twice. So that we dont have to handle the root case separately.
     */
    public boolean isSymmetric_iterative(TreeNode root) {

        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode Node1 = q.poll();
            TreeNode Node2 = q.poll();

            if (Node1 == null && Node2 == null)
                continue;

            if (Node1 == null || Node2 == null)
                return false;

            if (Node1.val != Node2.val)
                return false;
            q.add(Node1.left);
            q.add(Node2.right);
            q.add(Node1.right);
            q.add(Node2.left);
        }

        return true;

    }

}
