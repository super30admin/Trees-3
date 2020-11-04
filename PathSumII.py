#Time Complexity : O(n^2) where n is number of nodes in the tree
#Space Complexity : O(n) where n in the number of nodes in the tree

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Keeping a result array which holds all the paths (Root to leaf) which has a sum equal to the traget and a temp path array which holds each root to leaf path, also keeping a sum for each path. On reaching a leaf node, we check if the currSum equals to the target, then we put a copy of the curr path in the result array. If it is not a leaf node, then we recursively traverse left and right and continue finding paths and their sums. On finishing one path from root to leaf, we finally pop elements as we are done visiting all the children of it, as we do not require it in other paths.

#Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        self.result = []
        self.sum = sum

        def find(root, path, currSum):
            if not root:
                return

            path.append(root.val)
            currSum += root.val

            if not root.left and not root.right and currSum == self.sum:
                self.result.append(path[:])

            else:
                find(root.left, path, currSum)
                find(root.right, path, currSum)

            path.pop()

        find(root, [], 0)
        return self.result
