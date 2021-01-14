'''
Backtrack Solution
Time Complexity : O(n)
Space Complexity: O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        out = []
        def sum1Backtrack(root, localSum,path):
            if(root==None):
                return
            localSum += root.val
            if(root.left==None and root.right==None):
                nonlocal out
                if(localSum == sum):
                    out.append(path + [root.val])
                return
            path.append(root.val)
            
            sum1Backtrack(root.left, localSum, path)
            sum1Backtrack(root.right, localSum, path)
            # BACKTRACKING
            path.pop()
        
        sum1Backtrack(root, 0, [])
        return out
