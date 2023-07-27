//Problem 1: Path Sum 2
//Time Com: O(n) * num of pathto sum(constant) -> Basically O(n) 
//Space Comp O(h) - any given time, list of height of nodes will be required
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//one way of doing but too much space
// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         this.res=new ArrayList<>();
//         inorder(root, targetSum, 0, new ArrayList<>());
//         return res;
//     }
//     private void inorder(TreeNode root, int target, int curSum, List<Integer> path){
//         if(root==null) return;

//         curSum+=root.val;
//         //path.add(root.val); all paths would be added because same reference is passed eberuwhere
//         List<Integer> copyList= new ArrayList<>(path); //create new list with all previous PATH. then add current root.
//         copyList.add(root.val);
//         if(root.left == null && root.right == null){
//             if(curSum == target) //check if curSum is equal to target, if yes then add to current path to result.
//                 res.add(copyList);
//         }
//         inorder(root.left, target, curSum, copyList);
//         inorder(root.right, target, curSum, copyList);
        
//     }

// }

//way with new List in the recursive function itself
// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         this.res=new ArrayList<>();
//         inorder(root, targetSum, 0, new ArrayList<>());
//         return res;
//     }
//     private void inorder(TreeNode root, int target, int curSum, List<Integer> path){
//         if(root==null) return;

//         curSum+=root.val;
//         path.add(root.val);
//         if(root.left == null && root.right == null){
//             if(curSum == target)
//                 res.add(path);
//         }
//         inorder(root.left, target, curSum, new ArrayList<>(path));
//         inorder(root.right, target, curSum, new ArrayList<>(path));
//     }

// }

//solution with backtracking(less space in this case)
//Time Com: O(n) * num of pathto sum(constant) -> 
//Space Comp O(h) - any given time, list of height of nodes will be required
// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         this.res=new ArrayList<>();
//         inorder(root, targetSum, 0, new ArrayList<>());
//         return res;
//     }
//     private void inorder(TreeNode root, int target, int curSum, List<Integer> path){
//         if(root==null) return;

//         curSum+=root.val;
//         path.add(root.val);
        
//         if(root.left == null && root.right == null){
//             if(curSum == target) //check if curSum is equal to target, if yes then add to current path to result.
//                 res.add(new ArrayList<>(path)); //add as new arraylist because if u add path then further path will be changed and empty at root.
//         }
//         inorder(root.left, target, curSum, path);
//         inorder(root.right, target, curSum, path);
//         path.remove(path.size()-1); //backtracking logic
//     }

// }

//solution with Path, targetSum, CurSum variable in global scope
//Approach: here we are need List of list as a result, so basically a pointer reference is required. if we keep on making changes to the current list after being added to result, we are making changes to the reference pointer, so at the end, it will be changing elements from out result added list too.
// to tackle this issue, anytime we satisfy targetSum conditions, we add into result as a new reference so that we dont make recurrent changes to the same list 
// Also when we are coming back when our targetSum conditions does not satisfy, we still have that leaf node in list when we think recursion can handle it. recursion cannt internally handle data pointers but datatypes like int, boolean can be internally handled through local scope.
// arrays, arraylist will act as a global scope pointer even. hence we remove the current leaf node from list when we go back in the tree. 
class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    int target, curSum ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.res=new ArrayList<>();
        this.path = new ArrayList<>();
        this.target = targetSum;
        this.curSum=0;
        inorder(root);
        return res;
    }
    private void inorder(TreeNode root){
        if(root==null) return;

        curSum+=root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(curSum == target) //check if curSum is equal to target, if yes then add to current path to result.
                res.add(new ArrayList<>(path)); //add as new arraylist because if u add path then further path will be changed and empty at root.
        }
        inorder(root.left);
        inorder(root.right);
        curSum-=root.val;
        path.remove(path.size()-1); //backtracking logic
    }

}

//Problem 2: Symmetric Tree
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Approach: here we want leftsubtree to be exact mirror of right sub tree-> left child of left sub tree is equal to right child in right subtree and vice versa
// We try to traverse recursively in dfs approach to left.left and right.right check , also left.right and right.left check. 
// BFS Approach: here we want to check level order traversal is a palindrome or not, as the parents and children are both mirror images, they should also be palindromes.
class Solution {
    //Non Optimal Solution -> inorder should be a palindrome. 
    // public boolean isSymmetric(TreeNode root) {
    //     Queue<TreeNode> que= new LinkedList<>();
    //     que.add(root);
    //     while(!que.isEmpty()){
    //         int size=que.size();
    //         List<TreeNode> li=new ArrayList<>();
    //         for(int i=0;i<size;i++){
    //             TreeNode cur=que.poll();
    //             li.add(cur);
    //             if(cur!=null){
    //             que.add(cur.left);
    //             que.add(cur.right);
    //             }
    //         }
    //         int l=0, r=li.size()-1;
    //         while(l<r){
    //             if(li.get(l)==null && li.get(r)==null){
    //                 l++; r--;
    //             }
    //             else if(li.get(l)==null || li.get(r)==null){
    //                 return false;
    //             }
    //             else{
    //                 if(li.get(l).val!=li.get(r).val)
    //                     return false;
    //                 else{
    //                     l++;r--;
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }

    //O(n) space : O(1)
    // public boolean isSymmetric(TreeNode root) {
    //     Queue<TreeNode> que= new LinkedList<>();
    //     if(root==null) return true;
    //     que.add(root.left);
    //     que.add(root.right);
    //     while(!que.isEmpty()){
    //         TreeNode left= que.poll();
    //         TreeNode right= que.poll();

    //         if(left==null && right==null) continue;
    //         if(left==null || right==null) return false;
    //         if(left.val!=right.val) return false;

    //         que.add(left.left);
    //         que.add(right.right);
    //         que.add(left.right);
    //         que.add(right.left);
    //     }
    //     return true;
    // }

    //dfs approach
    // boolean flag;
    // public boolean isSymmetric(TreeNode root) {
    //     if(root==null) return true;
    //     this.flag=true;
    //     dfs(root.left, root.right);
    //     return flag;
    // }

    // private void dfs(TreeNode left, TreeNode right){
    //     //base
    //     if(left==null && right==null) return;
    //     //logic
    //     if(left==null || right==null || left.val != right.val){
    //         flag=false;
    //         return;
    //     }
    //     if(flag)
    //         dfs(left.left, right.right);
    //     if(flag)
    //         dfs(left.right, right.left);

    // }

    //boolean based recursion
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right){
        //base
        if(left==null && right==null) return true; // both children are null
        //logic
        if(left==null || right==null || left.val != right.val){ //one of them is null  -> not same, return false
            return false;
        }
        
        boolean leftsLeft = dfs(left.left, right.right);
        if(!leftsLeft) return false; // if left.left !=right.right -> return false
        
        return dfs(left.right, right.left); // if they are true, return left.right==right.left

    }
}