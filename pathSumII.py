"""
TC - O(n)
SC - O(h)
"""
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(node, sm):
            if not node: return []
            if not node.left and not node.right and sm == node.val:
                return [[node.val]]

            left = dfs(node.left, sm - node.val)
            right = dfs(node.right, sm - node.val)
            return [x + [node.val] for x in left + right]

        return [s[::-1] for s in dfs(root, targetSum)]