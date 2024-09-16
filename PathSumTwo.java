// Time Complexity : O(N) N=number of elements  in  the TREE. 
// Space Complexity : O(max depth of tree) space used because of current path list.
//  Space ComplexityWith recursive stack is: O(max(depth of tree)+ max( depth of tree)). We use a List with current path.  
// Any problem you faced while coding this :


// We traverse the tree recursively from left to right and with backtraking avoid creating new linked list in each recursive call.   
//Success
//Details 
//Runtime: 1 ms, faster than 99.96% of Java online submissions for Path Sum II.
//Memory Usage: 39.6 MB, less than 22.73% of Java online submissions for Path Sum II.
   public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resp=new ArrayList<>();
        List<Integer> cPath=new ArrayList<>();
        if (root ==null)
            return resp;
         recSum(root,0, sum,resp,cPath);
        return resp;
        
    }
    
    private void recSum(TreeNode root, int sum, int target,List<List<Integer>> resp,List<Integer> cPath){
        int cSum= sum+ root.val;
        cPath.add(root.val);
        if (root.left==null && root.right==null && cSum==target){//leaf
             ArrayList<Integer> tmp= new ArrayList<>(cPath);
             resp.add(tmp);
             return;
        }
        if (root.left!=null){
           recSum(root.left, cSum,target, resp, cPath);
           cPath.remove(cPath.size()-1);
        }
        if (root.right!=null){
           recSum(root.right,cSum,target, resp, cPath);
           cPath.remove(cPath.size()-1);   
        }
    }