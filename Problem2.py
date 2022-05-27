#Time Complexity : O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        queue = [root]
        queue.append(root)
        
        while queue:
            node1 = queue.pop()
            node2 = queue.pop()
            
            if node1 == None and node2 ==None:
                continue
            if node1 == None or node2 == None:
                return False
            if node1.val != node2.val:
                return False
            queue.append(node1.left)
            queue.append(node2.right)
            queue.append(node1.right)
            queue.append(node2.left)
            
            
        return True

#RECURSIVE

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        return self.helper(root.left,root.right)
    
    def helper(self,root_left,root_right):
        if root_left == None and root_right == None:
            return True
        if root_left == None or root_right==None:
            return False
        if root_left.val != root_right.val:
            return False

        return self.helper(root_left.left,root_right.right) and self.helper(root_left.right,root_right.left)