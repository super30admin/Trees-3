# Time Complexity :
# O(N)  - Size of the Tree

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We do a inorder traversal in two different ways - (left, root, right) and (right,root, left). If both left and right value are same, and the left subtree and right subtree are mirrors,then we return True. Else we return False

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.SymmetricTraverse(root,root)

    def SymmetricTraverse(self,leftRoot,rightRoot):
        if leftRoot == None and rightRoot == None :
            return True
        if leftRoot != None and rightRoot == None :
            return False
        if leftRoot == None and rightRoot != None :
            return False

        left_tree = self.SymmetricTraverse(leftRoot.left,rightRoot.right)
        if not left_tree :
            return False
        if leftRoot.val != rightRoot.val :
            return False
        right_tree = self.SymmetricTraverse(leftRoot.right,rightRoot.left)

        return  left_tree and right_tree 
