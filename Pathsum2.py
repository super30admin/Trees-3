"""
We use recursion to explore all root-to-leaf paths while accumulating the sum and tracking the path.
If we reach a leaf and the current sum equals the target, we add a copy of the path to the result.
After recursive calls, we backtrack by removing the last element to restore the path for other branches.

"""
#Time Complexity; O(N)
#Space Complexity: O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.sum = targetSum
        self.helper(root,0,[])
        return self.result

    def helper(self,root,curr,path):

        if root is None:
            return 

        curr+=root.val
        path.append(root.val)
        if root.left is None and root.right is None and curr == self.sum:
            self.result.append(list(path))
        self.helper(root.left,curr,path)
        self.helper(root.right,curr,path)
        path.pop()

            


        