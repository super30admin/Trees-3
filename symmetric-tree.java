// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// start with root, check if left and right nodes have same value then check if left of left and right od right are same
// and right of left and left of right are same. keep checking recursevely. if its not equal anywhere, return false, else true.

//dfs
public boolean isSymmetric(TreeNode root) {
    return check(root,root);
}

public boolean check(TreeNode t1, TreeNode t2){
    if(t1 == null && t2 == null) return true;
    if(t1 == null || t2 == null) return false;
    
    return (t1.val == t2.val) && check(t1.left, t2.right) && check(t1.right, t2.left);
}


// bfs
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    Queue<TreeNode> q1 = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        TreeNode curr = q.poll();
        q1.add(curr);
            if(curr != null){
            q.add(curr.left);
            q.add(curr.right);
            }
    }
    q.clear();
    Queue<TreeNode> q2 = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        TreeNode curr = q.poll();
        q2.add(curr);
        if(curr != null){
            q.add(curr.right);
            q.add(curr.left);
        }
    }
    System.out.println(q1.size() + " " + q2.size());
    if(q1.size() == q2.size()){
        int size = q1.size();
        for(int i = 0; i<size; i++){
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            System.out.print(t1 + " " + t2);
            if(t1 == null || t2 == null){
                    if(t1 == null && t2 == null){
                        continue;
                    } return false;
            } 
            System.out.println(t1.val + " " + t2.val);
            if(t1.val != t2.val) return false;
        }
    } else return false;
    return true;        
}