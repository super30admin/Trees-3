#Time Complexity : O(n)
#Space Complexity : O(n)
#Did your code run on leetcode : yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        queue = deque()
        queue.append(root.left)
        queue.append(root.right)
        
        while(len(queue) != 0):
            left = queue.popleft()
            right = queue.popleft()
            
            if left == None and right == None: continue
            if left == None or right == None or left.val != right.val: return False
            
            #pushed in pair of two left.left with right.right and left.right with right.left 
            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)
            
        return True
    
