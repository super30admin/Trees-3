TC:O(N)
SC:O(H)

// Here nodes are appended to a list until the base condition is met which left and right nodes are null;
// Along with each node I am carrying the sum as well ,evertime I hit the base condition I will check if sum==targetsum'
// if so i will enter the array into the final ans array 
// preorder traversal

class Solution {
    List<List<Integer>>ans;
    // List<List<Integer>>ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {   
        ans = new ArrayList<>();
        if(root==null) return ans;
        List<Integer> temp = new ArrayList<>();
         Pathsum(root, 0, targetSum, temp);

        // Pathsum(root,0,targetSum,temp);
        return ans;
    }

    void Pathsum(TreeNode root,int currsum,int targetSum,List<Integer>temp)
    {
        if(root==null) 
        {
            return;
        }
        temp.add(root.val);   
        if(root.left == null && root.right==null)
        {
            currsum+=root.val;
            if(currsum==targetSum)
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
      
        Pathsum(root.left, currsum+root.val,targetSum,temp);
        Pathsum(root.right, currsum+root.val,targetSum,temp);
        temp.remove(temp.size()-1);
    }
}
