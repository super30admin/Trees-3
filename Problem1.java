//Accepted on LT
//Maintain sum and check with target and while backtracking remove last element from list.
//Time should be O(n)

class Solution {
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> l2 = new ArrayList<>();
        helper(root,l2,0,targetSum);
        return l;
    }
    public void helper(TreeNode root,List<Integer> l1,int cr,int t){
        //base
        if(root==null) return;

        //logic
        cr= cr+root.val;
        l1.add(root.val);
        if(root.left==null && root.right==null){
            if(cr==t){
                l.add(new ArrayList<>(l1));
                
            }
            
       
    
            
        }


        helper(root.left,l1,cr,t);
        helper(root.right,l1,cr,t);
        l1.remove(l1.size()-1);
        
    }
}