## Time Complexity : O(n), n is number of nodes in tree
## Space Complexity : O(h),h is the height of the tree
## Did this code successfully run on Leetcode : Yes
#Approach: For ever node in  left subtree  we have to check if it's right child is identical to right child of the node in right subtree subtree and similarly for left child in left subtree and right child in right subtree.
#If these are identical then they are mirror images of each other.
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root, root)

    def isMirror(self, tree1, tree2):
        if tree1 is None and tree2 is None:
            return True
        if tree1 is None or tree2 is None:
            return False
        return (tree1.val == tree2.val) and self.isMirror(tree1.left, tree2.right) and self.isMirror(tree1.right,
                                                                                                     tree2.left)
