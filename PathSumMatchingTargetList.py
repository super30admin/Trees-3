# // Time Complexity : using deep copy o(n*h) using same path variable o(n)
# // Space Complexity : deep copy o(nH) otherwise o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : pass by value and pass by refernce conctp


# // Your code here along with comments explaining your approach
# pass curr sum as  pass by value as a scope of recursion (here since it is primitive and not ds it will be by value)so each call will have its own version 
# since the path is passed by reference we need to create new refernces and add them to result whenever condition is met
# but to avoid extra space we can use backtrack active - recurese backtract the action to form the correct ans


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from typing import List, Optional
# class Solution:
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
#         res, path,currSum = [],[], 0
        
#         def helper(root, path, currSum, targetSum):
#             if not root : return 

#             currSum +=root.val
#             li = path[:] #need to do this to have diff references otherwise we are modifying same path refernces
#             li.append(root.val)
#             if not root.left and not root.right and currSum == targetSum:
#                 res.append(li)
#             helper(root.left, li, currSum, targetSum)
#             helper(root.right, li, currSum, targetSum)
#         helper(root, path, currSum, targetSum)
#         return res

# Definition for a binary tree node.

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res, path,currSum = [],[], 0
        
        def helper(root, path, currSum, targetSum):
            if not root : return 
            currSum+=root.val
            path.append(root.val)
            if not root.left and not root.right and currSum == targetSum:
                res.append(path.copy())
            helper(root.left, path, currSum, targetSum)
            helper(root.right, path, currSum, targetSum)
            path.pop()
        helper(root, path, currSum, targetSum)
        return res




    
        


    
        