# https://leetcode.com/problems/path-sum-ii/

# Time Complexity: O(n*h), O(n^2) worst case scenario
# Space Complexity: O(h*h)

# This solution explores maintaining a currsum at every node and also creates 
# a deep copy of the list passed on from the parent node and appends to this new list. 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        self.helper(root, 0, targetSum, [], res)
        return res

    def helper(self, root, currSum, targetSum, path, res):

        if root == None:
            return None

        currSum += root.val
        currList = path.copy()
        currList.append(root.val)
        
        if root.left is None and root.right is None:
            if currSum == targetSum:
                res.append(currList)
            
        self.helper(root.left, currSum, targetSum, currList, res)
        self.helper(root.right, currSum, targetSum, currList, res)


        

        