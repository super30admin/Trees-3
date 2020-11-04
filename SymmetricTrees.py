#Time Complexity : O(n) where n is number of nodes in the tree
#Space Complexity : O(n) where n in the number of nodes in the tree

#Did this code successfully run on Leetcode : Yes
'''Three line explanation of solution in plain english: Starting from root, check the following conditions:
1) left child and right child values are both Null. -> Return True (as they are equal)
2) if either only one child is Null and the other is not Null, then both are not equal. -> Return False
3) If values of both children are different, then they are not equal. -> Return False
4) Keep recursively checking all subtrees, but checking one subtrees left with the others right and vice-versa as we are looking for mirror image so they will on the opposite sides. -> If both trees satisfy the conditions, then return True, else False.'''

#Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:

        if not root:
            return True

        def checkSymmetry(one, two):
            if not one and not two:
                return True
            if not one or not two:
                return False
            if one.val != two.val:
                return False
            return checkSymmetry(one.left, two.right) and checkSymmetry(one.right, two.left)

        return checkSymmetry(root, root)
