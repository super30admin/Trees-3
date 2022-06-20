//Time Complexity=O(n)
//Space Complexity=O(n)
public class MirrorCheckTree {
    public boolean isSymmetric(TreeNode root) {

        Stack<TreeNode> st=new Stack<>();
        st.add(root);
        st.add(root);
        int count=0;
        while(!st.isEmpty()){
            TreeNode t1=st.pop();
            TreeNode t2=st.pop();

            if(t1==null && t2==null) continue;
            if(t1==null || t2==null) return false;
            if(t1.val!=t2.val) return false;

            st.push(t1.left);
            st.push(t2.right);
            st.push(t1.right);
            st.push(t2.left);
            count+=4;
            System.out.println(count);
        }
        return true;
        // return isMirrorTree(root,root);
    }

//     private boolean isMirrorTree(TreeNode t1, TreeNode t2){
//         if(t1==null && t2==null) return true;
//         if(t1==null || t2==null) return false;


//         return t1.val==t2.val && isMirrorTree(t1.left,t2.right)
//         && isMirrorTree(t1.right,t2.left);

//     }
}
