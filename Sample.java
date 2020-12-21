// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    private void recurseTree(TreeNode node, int remainingSum, List<Integer> pathNodes, List<List<Integer>> pathsList) {
        
        if (node == null) {
            return;
        }
        
       
        pathNodes.add(node.val);
        
        if (remainingSum == node.val && node.left == null && node.right == null) {
            pathsList.add(new ArrayList<>(pathNodes));
        } else {
            
            // Else, we will recurse on the left and the right children
            this.recurseTree(node.left, remainingSum - node.val, pathNodes, pathsList);
            this.recurseTree(node.right, remainingSum - node.val, pathNodes, pathsList);
        }
        
        // We need to pop the node once we are done processing ALL of it's
        // subtrees.
        pathNodes.remove(pathNodes.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        this.recurseTree(root, sum, pathNodes, pathsList);
        return pathsList;        
    }

// time complexity : O (N^2)
// Space Complexity : O(1)
