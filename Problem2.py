# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(n) 
    # sc : O(h) used for thr recrussive stack
    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        # intution 
    # to be mirrored, firstly the root will be same the tric part is to check ig the left subtree is mirrored to the rigth subtree
    # the left child of the left subtree hsould be equal to the right child of the right subtree and the right of the left sub tree should be equal to the 
    # left of the right subtree to be mirrored 
    # so recurssively the root1.left should be equal to the root2.right, root1.right should be equal tot he root1.left and also the toot values shoudl also be equal 
    # even if any one of the above condition is failed , means there is a breach, the tree is not mirrored. 

        if root is None: # if root is none empty then it it mirror to itself retuning true
            return True

        return self.helper(root.left,root.right)


    def helper(self,root1,root2):
        if root1 is None or root2 is None: # the root1 should be equal to the root2 
            return root1 == root2

        return root1.val == root2.val and self.helper(root1.left, root2.right) and self.helper(root1.right, root2.left)