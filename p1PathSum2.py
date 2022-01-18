"""
paths where the sum of the node values in the path equals targetSum.
 Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending 
at any leaf node. A leaf is a node with no children.

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        res = []
        stack = [(root, targetSum-root.val, [root.val])]
 
        while stack:
            curr, val, ls = stack.pop()
            if not curr.left and not curr.right and val == 0:
                res.append(ls)
            if curr.right:
                stack.append((curr.right, val-curr.right.val, ls+[curr.right.val]))
            if curr.left:
                stack.append((curr.left, val-curr.left.val, ls+[curr.left.val]))
        return res 