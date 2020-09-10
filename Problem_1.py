
# 113. Path Sum II

# Approach:  Iterate with DFS approach, at leaf check if the sum of all the path elements matches the target. If yes, add it to the result else continue to the other paths.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, target: int) -> List[List[int]]:
        res = []
        
        def helper(root, curr, res, target):
            if not root:
                return
            if not root.left and not root.right:
                if sum(curr)+root.val == target:
                    curr.append(root.val)
                    res.append(curr)
                    return
                
            helper(root.left, curr+[root.val], res, target)
            helper(root.right, curr+[root.val], res, target)
            
            if curr:
                del curr[-1]
            
            return
        
        helper(root, [], res, target)
        
        return res
        
# Time complexity: O(max(n, d*l)) max((Number of nodes), depth*number of leaf nodes)
# Space complexity: O(N) N-> Max depth
# Accepted on Leetcode: Yes.