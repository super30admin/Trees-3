#TimeComplexity:O(N) 
#SpaceComplexity: O(Depth) for recursion stack
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root==None:
            return True

        def recur(root1,root2):
            if root1==None and root2==None:
                return True
            if root1==None or root2==None or root1.val!=root2.val :
                print(root1,root2)
                return False
            return recur(root1.left,root2.right) and  recur(root1.right,root2.left)
        return recur(root.left,root.right)
        