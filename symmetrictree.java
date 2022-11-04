//T.C- O(n)
//S.C- O(n)

//   Definition for a binary tree node.
  public class symmetrictree {
      int val;
      symmetrictree left;
      symmetrictree right;
      symmetrictree() {}
      symmetrictree(int val) { this.val = val; }
      symmetrictree(int val, symmetrictree left, symmetrictree right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

class Solution {
    public boolean isSymmetric(symmetrictree root) {
        return mirror(root, root);
        
    }
    public boolean mirror(symmetrictree r1, symmetrictree r2){
        if(r1==null && r2==null){
            return true;
        }
        if(r1!=null && r2!=null && r1.val== r2.val){
            return mirror(r1.left,r2.right) && mirror(r1.right, r2.left);
        }
        return false;
    }
}
