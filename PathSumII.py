"""
Time Complexity : O(n)
Space Complexity : O(h)
Did this code successfully run on Leetcode :
Any problem you faced while coding this :
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return
        pathList = []
        self.helper(root, targetSum, [], pathList)
        return pathList
    def helper(self, root, targetSum: int, Nodes: [List[int]], pathList: List[List[int]]):
        if not root:
            return
        # Start by appending the root
        Nodes.append(root.val)
        # If the my root val is equal to target and no more children then append
        # the Nodes list to the pathList
        if targetSum == root.val and not root.left and not root.right:
            pathList.append(list(Nodes))
        # If sum not equal target sum then traverse through the left and right tree
        # from current root
        else:
            self.helper(root.left, targetSum - root.val, Nodes, pathList)
            self.helper(root.right, targetSum - root.val, Nodes, pathList)
        # Pop the elements at the end as we would need an empty list for the next 
        # path if it exists
        Nodes.pop()
            
            