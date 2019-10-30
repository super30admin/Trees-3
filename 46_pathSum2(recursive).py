# accepted in leetcode(113)
# time O(N), space O(H)
# Here, we are using a helper function and then moving rifht and left tree nodes and substracting the root.val each time checking for the condition when can we reach sum is equal to root.val, add the path to result list.
# if the root to leaf path does not correspond to the sum then the path is ignored.
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sum: int):
        res = []
        if not root:
            return []
        self.helper(root, sum, [], res)
        return res

    def helper(self, root, sum, lst, res):
        # reached leaf and sum is equal to leaf node val then add the path to result list.
        if root.left is None and root.right is None and sum == root.val:
            lst.append(root.val)
            res.append(lst)

        if root.left:
            self.helper(root.left, sum - root.val, lst + [root.val], res)  # recurse for left subtree
        if root.right:
            self.helper(root.right, sum - root.val, lst + [root.val], res)  # recurse for right subtree