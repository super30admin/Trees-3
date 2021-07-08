// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Maintaining the local list to get it as a result correctly.
/* Your code here along with comments explaining your approach: Sum along/ running sum each node value as you move towards the leaf. Capture your path while you are
moving to the leaf. If you have reached the leaf node, check if the sum you got matches the target sum, if yes then create a new list to put your
path copy in the result. As you backtrack, remove the last node encountered from the path you have till now, as they have been processed already and 
you have checked the sum.
*/
class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> temp = new ArrayList<>();
        sumCheck(root, sum, temp, 0);
        return result;
    }
    private void sumCheck(TreeNode root, int sum, List<Integer> temp, int currentSum){
        if(root == null){return;}                                                           // base case
        currentSum+=root.val;                                                               //Running sum
        temp.add(root.val);                                                                 // Adding nodes to the path
        if(root.left == null && root.right == null){                                        // if leaf node
            if(sum == currentSum){
            result.add(new ArrayList<Integer>(temp));                                   // Add the path you got that matches the sum
            }
        }
        sumCheck(root.left, sum, temp, currentSum);
        sumCheck(root.right, sum, temp, currentSum);
        temp.remove(temp.size()-1);                                                 // as you backtrack, remove the nodes as they have been processed already
    }

    /* ITERATIVE:

    class Tripple{                                                          // Using a triplet data structure to maintain at the stack
        TreeNode node;
        int sum1;
        ArrayList<Integer> path;
        Tripple(TreeNode node, int sum, ArrayList<Integer> path){
            this.node = node;
            this.sum1 = sum;
            this.path = path;
        }
        public TreeNode getNode(){return this.node;}
        public Integer getSum() { return this.sum1;}
        public List<Integer> getPath(){return this.path;}
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Tripple t = new Tripple(root, sum, temp);                           // Make the object initialised with the values
        Stack<Tripple> stack = new Stack<Tripple>();
        stack.push(t);
        int currentSum  = 0;
        while(stack.size()> 0){
            Tripple fetch = stack.pop();                                // Fetch the triplet: Node, Sum and Path
            TreeNode node = fetch.getNode();                            // Fetch the node
            if(node != null){
            currentSum = fetch.getSum();                                // Fetch the sum (target)
            temp = fetch.path;
            temp.add(node.val);                                         // Add the node to the path
            if(node.left == null && node.right==null && currentSum == node.val){                    // If leaf, check if total sum has subtracted to leaf node value
                    result.add(temp);                                                   // Add to the result
                }
            stack.push(new Tripple(node.left, currentSum-node.val, new ArrayList<>(temp)));             // Add the triplet if not leaf, subtract the node value from the total sum
            stack.push(new Tripple(node.right, currentSum-node.val, new ArrayList<>(temp)));            // Copy the path to the next frame
                
            }
            }
        return result;
    }  
}
*/

}