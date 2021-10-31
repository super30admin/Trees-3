# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)

# Time Complexity=O(n**2)
# Space Complexity=O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def pathsum(root,cur,cursum,targetSum):
            nonlocal result
            if not root:
                return
            if not root.left and not root.right and cursum+root.val==targetSum:
                cur.append(root.val)
                b=cur.copy()
                result.append(b)
                cur.pop()
            cursum+=root.val
            cur.append(root.val)
            pathsum(root.left,cur,cursum,targetSum)
            pathsum(root.right,cur,cursum,targetSum)
            cur.pop()
            return result
        result=[]
        return pathsum(root,[],0,targetSum)

## Problem2 (https://leetcode.com/problems/symmetric-tree/)

# Time Complexity=O(n)
# Space Complexity=O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def same(root1,root2):
            if not root1 and not root2:
                return True
            if not root1 or not root2:
                return False
            return (root1.val==root2.val) and same(root1.left,root2.right) and same(root1.right,root2.left)        
        return same(root,root)
        