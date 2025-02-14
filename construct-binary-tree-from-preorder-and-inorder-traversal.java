// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach:have implemented this by using recursive call and first to get the index of root by itterating the inorder loop where it follows left-root-right.
// from that index i get to know left and right range from inorder as well as from preorder then i able to form tree. 

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder);
    }
    public TreeNode helper(int[] preorder, int[] inorder){
        if(preorder.length == 0) return null;
        int rootValue=preorder[0];
        TreeNode root=new TreeNode(rootValue);
        int index=-1;
        for(int i=0;i<inorder.length;i++){
            if(rootValue == inorder[i]){
                index=i;
                break;
            }
        }
        int[] inLeft=Arrays.copyOfRange(inorder,0,index);
        int[] inRight=Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] preLeft=Arrays.copyOfRange(preorder,1,inLeft.length+1);
        int[] preright=Arrays.copyOfRange(preorder,inLeft.length+1,preorder.length);
        root.left= helper(preLeft,inLeft);
        root.right=helper(preright,inRight);
        return root;
    }
}


// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :same approach as i mentioned above but to get index of a root instead of itterating over the array for every recursion i have implemented hashmap of root node and corresponding index of inorder array by reducing the time complexity 




class Solution {
    int idx;
     HashMap<Integer,Integer> sMap=new HashMap<>();
       
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            sMap.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    public TreeNode helper(int[] preorder,int start,int end){
        if(start > end ){
            return null;
        }
      int rootValue= preorder[idx];
       idx++;
       TreeNode root=new TreeNode(rootValue);
       int rootIndex=sMap.get(rootValue);
      root.left=  helper(preorder,start,rootIndex-1);
      root.right=  helper(preorder,rootIndex+1,end);
        
         return root;
     
    }
}