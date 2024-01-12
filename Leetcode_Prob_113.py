# time: O(N)
# Space: O(N)
#approach: DFS
# We will be using DFS to traverse the tree and keep track of the current path and current sum. If the current node is a leaf node and the current sum is equal to the target sum, we will append the current path to the result. If not, we will traverse the left and right subtree and backtrack the current path.


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(node, current_path, current_sum):
            if not node:
                return

            current_path.append(node.val)
            current_sum += node.val

            if not node.left and not node.right:  # Leaf node
                if current_sum == targetSum:
                    result.append(current_path.copy())

            dfs(node.left, current_path, current_sum)
            dfs(node.right, current_path, current_sum)

            current_path.pop()  # Backtrack

        result = []
        dfs(root, [], 0)
        return result
