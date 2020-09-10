import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    static List<List<Integer>> l = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> l = new ArrayList<>();
        helper(root, "", 0, sum);
        for(String s : temp){
            String[] x = s.split("\\s+");
            List<Integer> lx = new ArrayList<>();
            if(x.length > 0){
                for(String str : x){
                    if(!str.equals(""))
                        lx.add(Integer.parseInt(str));
                }
                l.add(lx);
            }
        }
        return l;
    }

    public static class TreeNode {
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
    }
    
    static List<String> temp = new ArrayList<>();
    public static int helper(TreeNode root, String sum, int val, int res){
        if(root == null)
            return 0;
        
        //multiply the val by 10 and add the current root value
        val = val + root.val;
        sum = sum + " " + root.val;
        
        // if at leaf node directly return the val
        if(root.left == null && root.right == null && val == res){
            // System.out.println(sum);
            temp.add(sum);
            // System.out.println("-----------------");
            return val;
        }
        
        //recursively 
        return helper(root.left, sum, val, res) + helper(root.right, sum, val, res);
    }
    public static void main(String[] args) {
        TreeNode r = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(pathSum(r,3));
    }
}