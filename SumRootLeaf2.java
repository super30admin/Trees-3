// Time Complexity : O(max(n,c*maxdepth))
// Space Complexity : O(1) , no extra space , O(n) when recursive stack included
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//At each node, we need to keep track of sum so far and also the prev path
//recur till leaf node keeping track of sum, if the sum is eqal to target, add the list to output and remove the last element of list to move back to root
//recur on left and right 
//if we want to add the list to the output, addit as new Arraylist as java as pass by reference and it would replace the existing list  in output


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return new ArrayList<>();
        int sumsoFar=0;
        List<Integer> list=new ArrayList<>();
        recurr(root,sumsoFar,sum,list);
        return res;
    }
    List<List<Integer>> res=new ArrayList<>();
  
    private void recurr(TreeNode root,int sumsoFar,int sum,List<Integer> list){
        if(root==null) return;
        if(root!=null){
        list.add(root.val);
        sumsoFar+=root.val;}
        
        
        if(root.left==null&&root.right==null&&sumsoFar==sum){
               res.add(new ArrayList<>(list));
        }
  
    recurr(root.left,sumsoFar,sum,list);
    recurr(root.right,sumsoFar,sum,list);
    list.remove(list.size()-1);
}
}