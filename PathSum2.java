import java.util.LinkedList;
import java.util.List;


public class PathSum2 {

	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	     }
	
	public List<List<Integer>> l1= new LinkedList<>();
    public int count=0;
    public void helper(List<Integer> l, int target, TreeNode root, int sum){
    
         if(root== null){return;}
        
        if(root.left==null&&root.right==null){
           if(sum+root.val==target){
           l.add(root.val);
               l1.add(new LinkedList(l));  
               l.remove(l.size()-1);
          return;
           }else{return;}
         
       
       }
        
       
        l.add(root.val);
        sum=sum+root.val;
         
       
        
        helper(l,target,root.left,sum);
        helper(l,target,root.right,sum);
        l.remove(l.size()-1);
        
    }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     List<Integer> l= new LinkedList<>();
        helper(l,targetSum,root,0);
        return l1;
    }
	
	
	
}
}