import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author aupadhye
 *
 */

class Node  
{ 
    int data; 
    Node left, right; 
       
    Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
   

class Root_leaf_sum2 {
    
	
	Node root;
	
    private void recurseTree(Node node, int remainingSum, List<Integer> pathNodes, List<List<Integer>> pathsList) {
        
        if (node == null) {
            return;
        }
        
        // Add the current node to the path's list
        pathNodes.add(node.data);
        
        // Check if the current node is a leaf and also, if it
        // equals our remaining sum. If it does, we add the path to
        // our list of paths
        if (remainingSum == node.data && node.left == null && node.right == null) {
            pathsList.add(new ArrayList<>(pathNodes));
        } else {
            
            // Else, we will recurse on the left and the right children
            this.recurseTree(node.left, remainingSum - node.data, pathNodes, pathsList);
            this.recurseTree(node.right, remainingSum - node.data, pathNodes, pathsList);
        }
        
        // We need to pop the node once we are done processing ALL of it's
        // subtrees.
        pathNodes.remove(pathNodes.size() - 1);
    }
    
    public  List<List<Integer>> pathSum(Node root, int sum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        this.recurseTree(root, sum, pathNodes, pathsList);
        return pathsList;        
    }
    
    
    
    public static void main(String[] args) {
    	
    	
    	 Root_leaf_sum2 tree = new Root_leaf_sum2(); 
         tree.root = new Node(5); 
         tree.root.left = new Node(4); 
         tree.root.right = new Node(8); 
         tree.root.right.right = new Node(4); 
         tree.root.right.left = new Node(13); 
         tree.root.left.left = new Node(11); 
         tree.root.left.left.left = new Node(7); 
         tree.root.right.right.right = new Node(1); 
         tree.root.left.left.right = new Node(2); 
       
            
         System.out.print("Sum of all paths is " +  
                                  Arrays.asList(tree.pathSum(tree.root, 22)));   
    	
    	
    }
}
