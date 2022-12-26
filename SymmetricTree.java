import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {


    //https://leetcode.com/problems/symmetric-tree/
    //TC -O(n)
    //SC - O(h)
    /*
    * Formulate a recursive call with left and right nodes. One will point to left side of tree and another to right
    * side.
    * if left and right nodes are null then return
    * If there is mismatch between any nodes make value of isValid to false and return
    * keep continuing till you not encounter any left and right node for each node to be null
    *
    * */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));

    }
    /*BFS based approach. We use queue and at once add 2 nodes to the queue. If there is no mismatch
    we add left.left, right.right ,left.right, right.left nodes to the queue and will on loop till all the
    nodes are traversed (q is empty).

    * */

    public static boolean isSymmetric(TreeNode root) {
        if(root==null ) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
    while (!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left==null && right == null) continue;
            if(left==null || right==null || right.val!=left.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);

    }
    return true;


    }
    //DFS based approach with maintaining a direct comparison betwee left and right side of tree
/*
    static boolean isValid = true;
    public static boolean isSymmetric(TreeNode root) {
        if(root == null ) return true;
        dfs(root.left, root.right);
        return isValid;
    }
    private static void dfs(TreeNode left, TreeNode right){
        if(left ==null && right ==null )return;
        if(left==null|| right ==null || left.val!=right.val){
            isValid= false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }

*/

    /*
    * Below solution shows inorder traversal which stores nodes in list and if that list in palindrome then
    * return true otherwise false
    * */
    // TC - O(n)
    //SC - O(n)
    /*

    static List<Integer> result;
    private static boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        result = new ArrayList<>();
        dfs(root);
        System.out.println(result);
        int start = 0;

        int end = result.size()-1;
        while(start<=end){
            if(start!=end && result.get(start)!=result.get(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    private static void dfs(TreeNode root) {
        if(root==null) return;
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);

    }*/

}
