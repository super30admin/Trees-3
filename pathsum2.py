'''
Time Complexity : O(n^2)
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
        # missed one edge case
        out = []
        def sum1(root, localSum,path):
            if(root==None):
                return
            
            localSum += root.val
            
            if(root.left==None and root.right==None):
                nonlocal out
                if(localSum == sum):
                    out.append(path + [root.val])
                return
            
            
            sum1(root.left, localSum, path + [root.val])
            sum1(root.right, localSum, path + [root.val])
        
        sum1(root, 0, [])
        return out
