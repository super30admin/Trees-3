# Did this code successfully run on Leetcode : YES

# TC: O(N log N)
# SC: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        pathlist = []
        self.helper(root, targetSum, [], pathlist)
        return pathlist
        
    def helper(self, node, rsum, nodelist, pathlist):
        if not node:
            return
        # nonlocal res
        nodelist.append(node.val)
        if rsum == node.val and not node.left and not node.right:
            pathlist.append(list(nodelist))
        else:
            self.helper(node.left, rsum - node.val, nodelist, pathlist)
            self.helper(node.right, rsum - node.val, nodelist, pathlist)
        nodelist.pop()