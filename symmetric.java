//time: O(n);
//Space:O(1);

class Solution {
    public boolean isSymmetric(TreeNode root) {

        if(root.left!=null && root.right!=null){
            if(root.left.val!=root.right.val){
                return false;
            }
        }
        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode node1,TreeNode node2){
        if(node1==null){
            if(node2!=null){
                return false;
            }else{
                return true;
            }
        }else if(node2==null){
            if(node1==null){
                return true;
            }else{
                return false;
            }
        }

        else{
            if(node1.left!=null){
                if(node2.right==null){
                    return false;
                }
                else if(node1.left.val!=node2.right.val){
                    return false;
                }

            }
            if(node1.right!=null){
                if(node2.left==null){
                    return false;
                }
                else if(node1.right.val!=node2.left.val){
                    return false;
                }
            }


        }

        return helper(node1.left,node2.right) && helper(node1.right,node2.left);

    }
}