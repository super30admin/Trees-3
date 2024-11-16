# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        # Traversal Time:dfs o(n), copying path -o(h*n)=o(n^2)
        if not root:
            return []
        ans = []
        q = deque([(root, [root.val])])
        while q:
            cur, path = q.pop()
            if sum(path) == targetSum and not cur.left and not cur.right:
                ans.append(path)
            if cur.left:
                q.append((cur.left, path + [cur.left.val]))
            if cur.right:
                q.append((cur.right, path + [cur.right.val]))

        return ans

        def dfs(self, root, path, ans, remainingSum):
            # if it is None, then return
            if not root:
                return
            # add the current node val to path

            # ACTION
            path.append(root.val)
            # !node.left && !node.right : check if it is a leaf node
            # remainingSum == node.val: check if the remaining sum - node.val == 0
            # if both condition is true, then we find one of the paths
            if not root.left and not root.right and remainingSum == root.val:
                ans.append(list(path))
            # traverse left sub tree with updated remaining sum
            # we don't need to check if left sub tree is nullptr or not
            # as we handle it in the first line of this function

            # RECURSE
            self.dfs(root.left, path, ans, remainingSum - root.val)
            # traverse right sub tree with updated remaining sum
            # we don't need to check if right sub tree is nullptr or not
            # as we handle it in the first line of this function
            self.dfs(root.right, path, ans, remainingSum - root.val)
            # BACKTRACK
            path.pop()

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        ans = []
        self.dfs(root, [], ans, targetSum)
        return ans
