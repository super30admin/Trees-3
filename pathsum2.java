// Time Complexity : O(n) we visit every node once only hence O(n) where n=number of unique nodes
// Space Complexity : O(n*2^n) // please correct me if I am wrong , I add a new list for every iteration
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// My solution takes too much space, I think creating a new list for all the nodes makes it exponential 
// for example for root list with one element and then 2 lists with 2 elements and so on 

// 1*2+2*2^2+3*2^3+4*2^4 = n*2^n

class Solution {
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> leafNodes=new ArrayList<>();
    int resultSum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        if(root==null)
            return new ArrayList<List<Integer>>();
        
        resultSum=sum;
        
        List<Integer> test=new ArrayList<>();
        
        /* Get the leaf nodes that have the sum */
        helper(root,0,test);
        
        
        return result;
    }
    
    public void helper(TreeNode node,int prevSum, List<Integer> prevList)
    {
        if(node==null)
            return;
        
        prevSum+=node.val;
        
        // A new List for every Node, consisting of the past elements, please correct me wiht a better solution?
        //List<Integer> newList=new ArrayList<>(prevList);
        prevList.add(node.val);
        
        if(node.left==null && node.right==null && prevSum==resultSum)
           result.add(new ArrayList<>(prevList));
        
           // Left and Right 
        helper(node.left,prevSum,prevList);
        helper(node.right,prevSum,prevList);
        
        // Backtrack
        prevList.remove(prevList.size()-1);
        
    }
}
