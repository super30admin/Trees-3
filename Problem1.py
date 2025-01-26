# Similar to root sum to leaf but just add sum before the recurse and if its parsed completely backtrack by popping the leaf.
# TC: O(n)
# SC: O(h)
# Yes, this worked in leetcode


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        res = []
        currsum = 0
        self.recurse(root, [], res, currsum, targetSum)
        return res
        
    def recurse(self, Node, path, res, currsum, targetSum):
        if not Node:
            return
        currsum += Node.val
        path.append(Node.val)
        if not Node.left and not Node.right and currsum == targetSum:
                res.append(list(path))
        self.recurse(Node.left, path, res, currsum, targetSum)
        self.recurse(Node.right, path, res, currsum, targetSum)

        path.pop()
