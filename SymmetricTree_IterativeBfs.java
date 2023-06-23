import java.util.Queue;
import java.util.LinkedList;

public class SymmetricTree_IterativeBfs {


    //BFS - ITERATIVE - QUEUE


        public boolean isSymmetric(TreeNode root) {

            if(root == null) return true;

            if(root.left == null && root.right == null) return true;

            Queue<TreeNode> QNodes = new LinkedList<>();

            QNodes.add(root.left);
            QNodes.add(root.right);

            while(!QNodes.isEmpty()){

                TreeNode left = QNodes.poll();
                TreeNode right = QNodes.poll();

                if(left == null && right == null) continue;

                if(left == null || right == null || left.val != right.val) return false;

                QNodes.add(left.left);    QNodes.add(right.right);
                //BFS
                QNodes.add(left.right);   QNodes.add(right.left);

            }
            return true;
        }

}
