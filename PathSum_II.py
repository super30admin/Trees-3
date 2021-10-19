#TC = O(nlogn)
#SC = O(n)
#Compiled and run on LC

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def recur(self, node, rsum, pathnodes, pathlist):
        if (node == None):
            return

        pathnodes.append(node.val)

        if (rsum == node.val and node.left == None and node.right == None):
            pathlist.append(list(pathnodes))

        else:
            self.recur(node.left, rsum - node.val, pathnodes, pathlist)
            self.recur(node.right, rsum - node.val, pathnodes, pathlist)

        pathnodes.pop()

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        pathlist = []
        self.recur(root, targetSum, [], pathlist)
        return pathlist