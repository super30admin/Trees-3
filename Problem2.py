#Trees-3 
#Problem2 : https://leetcode.com/problems/symmetric-tree/
#All test cases passed on Leetcode
#Time complexity : O(N) 
#Because we traverse the entire input tree once, the total run time is O(n), n is the total number of nodes in the tree.
#Space Complexity-O(N)
#The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in O(n). Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def check(self,left,right):
        if left is None and right is None:
            return True
        if left is None or right is None or left.val!=right.val:
            return False
        return self.check(left.left,right.right) and self.check(left.right,right.left)

    
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        return self.check(root.left,root.right)
        