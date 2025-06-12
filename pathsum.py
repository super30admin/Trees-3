#Time Complexity: O(n)
#Space Complexity: O(h)
# Did this problem run in Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []

        def dfs(node, path, current_sum):
            if not node:
                return

            # Adding current node to path
            path.append(node.val)
            current_sum += node.val

            # If it's a leaf and sum matches add a copy of the path to result
            if not node.left and not node.right and current_sum == targetSum:
                res.append(list(path))

            dfs(node.left, path, current_sum)
            dfs(node.right, path, current_sum)

            path.pop()

        dfs(root, [], 0)
        return res