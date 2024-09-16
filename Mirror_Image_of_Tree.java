import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Time complexity is O(n) and Space complexity is O(n) for maintaining a queue of n nodes
class Node 
{ 
    int data; 
    Node left, right; 
  
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
  
class Mirror_Image_of_Tree
{ 
    Node root; 
  
  
  
    public boolean isSymmetric(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            Node t1 = q.poll();
            Node t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.data != t2.data) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
  
   
  
  
    public static void main(String args[]) 
    { 
        /* creating a binary tree and entering the nodes */
        Mirror_Image_of_Tree tree = new Mirror_Image_of_Tree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5);        
        System.out.println(tree.isSymmetric(tree.root)); 
  

  
    } 
} 
