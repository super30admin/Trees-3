// Time Complexity :O(n^2)
// Space Complexity :O(n^2)
class Solution {
     List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList();
        target=sum;
        finder(root,0,new ArrayList<Integer>());
        return result;
    }
    
    void finder(TreeNode n,int tsum,List<Integer> arr)
    {
        if(n==null)
            return;
        arr.add(n.val);    
        tsum+=n.val;
        if(n.left==null&&n.right==null)
        {
            if(tsum==target)
            {
            result.add(new ArrayList<>(arr));
            }
        }
        finder(n.left,tsum,arr);
        finder(n.right,tsum,arr);
        arr.remove(arr.size()-1);
        
    }
}

------------------------------------------------------------------------------

// Time Complexity :O(n)
// Space Complexity :O(n)



class Solution {
   public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
}

public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && isMirror(t1.right, t2.left)
        && isMirror(t1.left, t2.right);
}
}