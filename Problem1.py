# Time Complexity : O(n^2) because in the worst case deep copy operation can take place in all the leaf nodes.
# Space Complexity : O(h) for the recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  Here we accumulate both the sum and the path when we are traversing the tree.
# The path is an array which is passed by reference, so we need to enforce backtracking rules by popping the element after the recursive call.
# At the leaf nodes, if the target sum is the same as the path sum, then we create a deep copy of the path and store it in the result.
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        
        def helper(root, sm, target, path, res):
            if not root:
                return
            
            sm += root.val
            if not root.left and not root.right and sm == target:
                res.append(path[:] + [root.val])
            
            path.append(root.val)
            helper(root.left, sm, target, path, res)
            helper(root.right, sm, target, path, res)
            path.pop()
                

        helper(root, 0, targetSum, [], res)
        return res