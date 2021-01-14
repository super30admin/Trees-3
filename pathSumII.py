# Time Complexity : O(N)
# Space Complexity : O(H) h = height
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        """ 
        Use backtracking.. similar to recursion but backtracking saves space and don't 
        have to keep creating lists this way..
        -Internet cut out mid lecture so tried implementing in python-
        """
        res = []
        if not root:
            return res
        
        def helper(root, currSum, path, target):
            if not root:
                return 
            #pick
            currSum += root.val 
            path.append(root.val)
            
            #choose
            if not root.left and not root.right:
                if currSum == target:
                    res.append(list(path))
                    
            helper(root.left, currSum, path, target)
            helper(root.right, currSum, path, target)
            
            #unchoose
            path.pop()
                    
        helper(root, 0, [], sum)
        return res