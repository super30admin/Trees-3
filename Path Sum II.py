# Time Complexity : O(n^2) n nodes * n times copying path to result
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        def helper(root,path,target):
            #base
            if root == None:
                return
            #logic
            path.append(root.val)
            target -= root.val
            if target == 0 and root.left == None and root.right == None:
                result.append(list(path))
            else:
                helper(root.left,path,target)
                helper(root.right,path,target)
            path.pop()

        helper(root,[],targetSum)
        return result