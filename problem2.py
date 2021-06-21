# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root.left == None and root.right == None: return True
        result = True
        
        
    
        def helper(left, right):
            if left == None and right == None:
                return True
        
            
            elif left == None or right == None:
                return False
           
            if left.val == right.val:
                case1 = helper(left.right, right.left)
                case2 = helper(left.left, right.right)
                return case1 and case2
            
        
        return helper(root.left, root.right)

#Time complexity O(n) and space complexity is O(1)
#comparing the values of left.right with right.left and left.left with right.right at each node