# Time Complexity: O(n) where n is the number of nodes
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        self.result = []
        def helper(root,targetSum, currentSum, path):
            if root == None:
                return 
            path.append(root.val)
            if root.left == None and root.right == None:
                if currentSum  + root.val == targetSum:
                    # path.append(root.val)
                    print(list(path))
                    self.result.append(list(path))
            helper(root.left, targetSum, currentSum  + root.val,path)
            helper(root.right, targetSum, currentSum  + root.val,path)
            path.pop()
            
        helper(root,targetSum,0, [])
        return self.result
