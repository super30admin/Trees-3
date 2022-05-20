# Time Complexity : O(h) where h is height of the tree
# Space Complexity : O(h) where h is height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
    
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.traverse(root, 0, [], targetSum)
        return self.result
        
    def traverse(self, root, currSum, currList, target):
        if root == None:
            return
        
        currList.append(root.val)
        currSum += root.val
        
        self.traverse(root.left, currSum, currList, target)
        
        if root.left is None and root.right is None:
            if currSum == target:
                self.result.append(currList[:])
        
        self.traverse(root.right, currSum, currList, target)
        
        currList.pop()