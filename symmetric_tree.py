# # Definition for a binary tree node.
# # class TreeNode:
# #     def __init__(self, val=0, left=None, right=None):
# #         self.val = val
# #         self.left = left
# #         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # bfs Solution: time complexity is O(n), space complexity is O(n)
        q = deque([root])

        while q:
            list_tree = []
            size = len(q)
            for i in range(size):
                curr = q.popleft()

                if curr:
                    list_tree.append(curr.val)
                    q.append(curr.left)
                    q.append(curr.right)
                else:
                    list_tree.append(None)

            if list_tree != list_tree[::-1]:
                return False
        return True


# dfs solution: time complexity is O(n), space complexity is O(h)
class Solution:

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        return self.helper(root.left, root.right)

    def helper(self, left, right):
        if left is None and right is None:
            return True
        if left is None or right is None:
            return False
        if left.val != right.val:
            return False
        return self.helper(left.left, right.right) and self.helper(
            left.right, right.left
        )
