
//Time Complexity: O(N) where N is the number of nodes in the tree
//Space Complexity: O(h) for the recursion stack 


//we use recursion to traverse the tree and keep track of the current path and its sum
//when we reach a leaf node we check if the current sum is equal to target sum.
//if it is we add the current path to the answer list
//we backtrack by removing the last node from the current path before returning to the previous node

class Solution {
    //backtracking
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.ans=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();
        helper(root,targetSum,path,0);
        return ans;
    }
    void helper(TreeNode root,int target,ArrayList<Integer> path,int currsum){
        if(root==null)
            return;
        
        currsum+=root.val;
        path.add(root.val);

        if(root.left==null&&root.right==null){
            if(currsum==target)
                ans.add(new ArrayList<>(path));
        }
        helper(root.left,target,path,currsum);
        helper(root.right,target,path,currsum);

        path.remove(path.size()-1);
    }
}