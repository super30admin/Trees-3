
// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :YES  
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class PathSumTwo {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>();
        if(root==null){ return result;}
        helper(root,targetSum,0,new ArrayList<>());
        return result;
    }
    void helper(TreeNode root, int targetSum,int sum,List<Integer>path){
        if(root==null){
            return;
        }
        sum=sum+root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left,targetSum,sum,path);
        helper(root.right,targetSum,sum,path);
        path.remove(path.size()-1);
    }
}
