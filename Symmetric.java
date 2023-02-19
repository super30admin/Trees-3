import java.util.ArrayList;
import java.util.List;
//TC=O(N) SC=O(h)-->Stack space  Recursive Solution
public class Symmetric {
    List<Integer> result = new ArrayList<>();
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left,root.right);

    }
    private boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)return true;
        else if(root1==null||root2==null) return false;
        else{
            return root1.val==root2.val && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
        }
    }
}
