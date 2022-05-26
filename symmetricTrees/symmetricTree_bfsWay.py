'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(n/2) -- last level of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach
'''
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        # 1. Initialize Queue
        queue = deque([])
        
        # 2. Enqueue the root
        queue.append(root)
        
        # 3. Iterate queue
        while queue != None:
            
            # Check the len of the queue
            
            if len(queue) == 0:
                return True
            
            elif len(queue) == 1:
                
                #print('\nCase 1: Queue is:\t',queue)
                # I just have a root
                ele = queue.popleft()
                queue.append(ele.left)
                queue.append(ele.right)
            
            else:
                
                #print('\nCase 2: Queue is:\t',queue)
                # I have to-do 2 dequeue
                lft = queue.popleft()
                rt = queue.popleft()
                
                # base-check
                if lft == None and rt == None:
                    continue
                
                elif (lft == None and rt != None) or (lft != None and rt == None):
                    return False
                
                elif lft.val != rt.val:
                    return False
                
                # enqueue lft.left and rt.right 
                # enqueue lft.right and rt.left
                
                queue.append(lft.left)
                queue.append(rt.right)
                
                queue.append(lft.right)
                queue.append(rt.left)
        
        return True