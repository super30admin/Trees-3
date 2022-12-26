import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
* Recursively track the path and append it to the resultant list when the calculated sum equals targetsum
* TC - O(n) - for touching all nodes but take into acc that you are copying elements at leaf
*               nodes in worst case can account to a certain constant eg level 3 it can take upto 2^3 = 8h
* SC - O(h)
*
*
* */
public class PathSumii {

    //https://leetcode.com/problems/path-sum-ii/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        System.out.println(pathSum(root,targetSum));
        //5,4,8,11,null,13,4,7,2,null,null,null,1]
    }
    //BackTracking
    static List<List<Integer>> result;
    static int target;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return Collections.emptyList();
        target = targetSum;
        result = new ArrayList<>();
        recurse(root,0,new ArrayList<Integer>());
        return  result;
    }

    private static void recurse(TreeNode root, int sum, ArrayList<Integer> path) {
        if(root==null) return;
        sum = sum+root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==target){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        recurse(root.left,sum,path);
        recurse(root.right,sum,path);
        path.remove(path.size()-1);


    }



    //Recursion base approach
    //Here when we recurse we are creating new array each time which can increase the space and time complexity
    //as we need to store all arrays so more space and increased time as we are copying path to new array
    /*
    static List<List<Integer>> result;
    static int target;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return Collections.emptyList();
        target = targetSum;
        result = new ArrayList<>();
        recurse(root,0,new ArrayList<Integer>());
        return  result;
    }

    private static void recurse(TreeNode root, int sum, ArrayList<Integer> path) {
    if(root==null) return;
    sum = sum+root.val;
    path.add(root.val);
    if(root.left==null && root.right==null){
        if(sum==target){
            result.add(path);
        }
        return;
    }
    recurse(root.left,sum,new ArrayList<>(path));
    recurse(root.right,sum,new ArrayList<>(path));


    }*/

}
