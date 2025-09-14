# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
Time Complexity: O(n)

Space Complexity: O(h) where h is the height of the tree

"""

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        ans = []

        def rec(node, curr, res): 
            # base case
            if not node: 
                return 

            res.append(node.val)
            curr += node.val

            #logic to add sum
            if node.left == None and node.right == None and curr == targetSum:
                ans.append(res[:])

            #recurse
            rec(node.left, curr, res)
            rec(node.right, curr, res)

            #backtrack
            res.pop()

        rec(root, 0, [])
        return ans



