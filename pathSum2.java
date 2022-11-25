// Time Complexity : O(n)
// Space Complexity :O(h) h-> height of the tree
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>();
        if(root==null) return result;
        target=targetSum;
        recurse(root,0,new ArrayList<>() );
        return result;
        
    }
    
    private void recurse(TreeNode root,Integer sum, List<Integer> list){
        if(root==null) return;
        sum=sum+root.val;
        list.add(root.val);
        
        if(root.left==null && root.right==null && sum==target){
            result.add(new ArrayList<>(list));
            
        }
        
        if(root.left!=null){
            recurse(root.left,sum,list);
        }
        
        if(root.right!=null){
            recurse(root.right,sum,list);
        }
        
        list.remove(list.size()-1);
    }
}