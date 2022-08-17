"""
Time Complexity : inside function
Space Complexity : inside function
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :No

Problem1 (https://leetcode.com/problems/path-sum-ii/)

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        """
        Time Complexity : O(N * H), N no of nodes in the list, H is the height of the tree
        Space Complexity :O(N)
        """
        self.res = []
        
        
        def helper(root, currSum, path, target):
            # Base Condition
            if root == None: return 
            
            # Logic
            currSum += root.val
            temp = copy.deepcopy(path)
            temp.append(root.val)
        
            if root.left == None and root.right == None:
                if currSum == target:
                    self.res.append(temp)
                    
            helper(root.left, currSum, temp, target)
            helper(root.right, currSum, temp, target)
            
        helper(root, 0, [] , targetSum)
        return self.res


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        """
        using DFS - Backtracking
        Time Complexity : O(N), N no of nodes in the list
        Space Complexity :O(N)
        """
        self.res = []
        self.path = []
        
        
        def helper(root, currSum, target):
            # Base Condition
            if root == None: return 
            
            # Logic
            # Action
            currSum += root.val
            self.path .append(root.val)
    
            if root.left == None and root.right == None and currSum == target:
                    self.res.append(list( self.path ))
            # recursion
            else:      
                helper(root.left, currSum, target)
                helper(root.right, currSum,target)
            #Backtracking
            self.path .pop()

        helper(root, 0,  targetSum)
        return self.res
                
            
                
            
                
            