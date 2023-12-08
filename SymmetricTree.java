// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {

    if(root== null)return false;

    Queue<TreeNode> queue= new LinkedList<>();

    queue.add(root.left);
    queue.add(root.right);

    while (!queue.isEmpty()){

      TreeNode l= queue.poll();
      TreeNode r= queue.poll();

      if (l== null && r == null) continue;
      else if (l== null || r == null) return false;
      else if(l.val != r.val) return false;

      queue.add(l.left);
      queue.add(r.right);
      queue.add(l.right);
      queue.add(r.left);

    }
    return true;
  }
}