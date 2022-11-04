 
//T.C- O(N^3)
//S.C- O(N)
import java.util.ArrayList;
import java.util.List;

//   Definition for a binary tree node.
  public class pathsumII {
      int val;
      pathsumII left;
      pathsumII right;
      pathsumII() {}
      pathsumII(int val) { this.val = val; }
      pathsumII(int val, pathsumII left, pathsumII right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    private void find(pathsumII root, int remainingsum, List<Integer> Pathnodes, List<List<Integer>> Pathlist ){
        if(root==null){
            return;
        }
        Pathnodes.add(root.val);
        if(remainingsum==root.val && root.left==null && root.right==null ){
            Pathlist.add(new ArrayList<> (Pathnodes));
        }else{
            this.find(root.left, remainingsum-root.val, Pathnodes, Pathlist);
            this.find(root.right, remainingsum-root.val, Pathnodes, Pathlist);
        }
        Pathnodes.remove(Pathnodes.size()-1);
    }
    public List<List<Integer>> pathSum(pathsumII root, int targetSum) {
        List<Integer> Pathnodes= new ArrayList<>();
        List<List<Integer>> Pathlist= new ArrayList<>();
        
        this.find(root, targetSum, Pathnodes, Pathlist);
        return Pathlist;
    }
}