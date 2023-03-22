# Time Complexity : O(n)
# Space Complexity : O(h) == O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
# at every node, at that to sum and current path , if its leaf node and sum is target, then add path to result
# iterate through left and right subtrees
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        global path
        path = []
        def findpaths(root,sumtillnow,currentpath):
            if not root: return
            sumtillnow+=root.val
            currentpath.append(root.val)
            if not root.left and not root.right:
                if sumtillnow == targetSum:
                    print(currentpath)
                    p = currentpath.copy()
                    path.append(p)
            findpaths(root.left, sumtillnow, currentpath)
            findpaths(root.right, sumtillnow, currentpath)
            currentpath.pop(-1)
        findpaths(root, 0, [])
        return path

            


