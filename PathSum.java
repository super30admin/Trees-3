// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.ArrayList;

class Node {
    int val;
    Node left;
    Node right;
    public Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Bst {
    Node root = new Node(5, new Node(4, new Node (11, new Node(7, null, null), new Node(2, null, null)), null), new Node(8, new Node(13, null, null), new Node(4, new Node(5, null, null), new Node(1, null, null))));
}

public class PathSum {

    PathSum() {
    }
    public void calculatePathSum(Node root, int sum, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        sum += root.val;
        arr.add(root.val);

        if (sum == 22) {
            System.out.println("reached");
            System.out.println(arr);
        }
        System.out.println(sum);
        calculatePathSum(root.left, sum, arr);
        calculatePathSum(root.right, sum, arr);
        arr.remove(arr.size()-1);
    }

  public static void main(String[] args) {
        PathSum ps = new PathSum();
        Bst bst = new Bst();
        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        ps.calculatePathSum(bst.root, sum, arr);
    }
}
