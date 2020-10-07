# Time Complexity: O(N)
# Space Complexity: O(N)
# Passed Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def recurse(self, root, arr, curr_total):
        curr_total += root.val
        arr.append(root.val)
        
        if not root.left and not root.right:
            
            if curr_total == self.sum:
                self.output.append(arr)
            return
        
        curr_len = len(arr)
        if root.left:
            
            self.recurse(root.left, arr, curr_total)
        
        if root.right:
            
            self.recurse(root.right, arr[0:curr_len], curr_total)
        
    
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if not root:
            return
        self.output = []
        self.sum = sum
        
        self.recurse(root, [], 0)
        return self.output



# Iterative Approach
# Time Complexity: O(N)
# Space Complexity: O(N)
# Passed Leetcode

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    

    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if not root:
            return
        output = []
        
        queue = deque()
        
        queue.append((root, [], 0, 0))
        
        while len(queue) > 0:
            
            node, arr, curr_total, curr_arr_len = queue.popleft()
            
            if curr_arr_len > 0:
                arr = arr[0:curr_arr_len]
            
            curr_total += node.val
            arr.append(node.val)
            
            if not node.left and not node.right:
                if curr_total == sum:
                    output.append(arr)
            else:
                
                if node.left:
                    queue.append((node.left, arr, curr_total, len(arr)))
                
                if node.right:
                    queue.append((node.right, arr, curr_total, len(arr)))
                
        return output