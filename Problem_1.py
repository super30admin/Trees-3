"""
Problem : 1

Time Complexity : O(n) 
Space Complexity : O(h) //h=height of the tree

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


creating a path array and current suum variable to store the current path traversed and sum of current leaf
if sum matches the target, then appending the entire path to result, then performing the backtracking step of removing the leaf node from path
this way we could eliminate extra time complexity to copy all the path to another array and appending it
"""

# Path sum II

# Approach - 1
# Backtracking

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def __init__(self):
        self.res=[]
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        self.helper(root,targetSum,0,[])

        return self.res
    
        

    def helper(self,root,targetSum,currSum,path):

        if root==None:
            return 0
        
        currSum=currSum+root.val
        path.append(root.val)
        
        if root.left==None and root.right==None:
            if currSum==targetSum:
                self.res.append(path[::])
        
        left=self.helper(root.left,targetSum,currSum,path)
        right=self.helper(root.right,targetSum,currSum,path)
        # backtracking step
        path.pop()

        return left+right