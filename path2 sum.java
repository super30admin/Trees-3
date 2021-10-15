//	Timecomplexity:- O(n);
//Space complexity:-O(n^2);
//Did it run on leetcode:- Yes.
//What were the problems faced while doing it?:- got some wrong answers initially.
//:- Your code with explanation:- adding rootvalue to current sum whenever we reach a new root at new level when we reach leaves checking sum with target 
//if sum equals target add all array elements to the list if not remove last element and repeating for other subtrees.

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> List=new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        pathsumhelper(root,targetSum,0,List,elements);
        return List;
        
    }
    private void pathsumhelper(TreeNode root,int target,int sum,List<List<Integer>> List,List<Integer> elements){
        if(root==null){
            return ;
        }
        sum=sum+root.val;
        elements.add(root.val);
        if((root.left==null)&&(root.right==null)){
            if(sum==target){
                 List<Integer> temp=new ArrayList<>(elements);
                 List.add(temp);
                
            }
            elements.remove(elements.size()-1);
            return;
        }
         pathsumhelper(root.left,target,sum,List,elements);
         pathsumhelper(root.right,target,sum,List,elements);
        
        elements.remove(elements.size()-1);
    }
}