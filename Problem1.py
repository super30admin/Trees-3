# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.out = []
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        self.helper(root,0,[],targetSum)
        return self.out
    
    def helper(self,root,t,arr,f):
        
        if root == None:
            return;
        arr.append(root.val)
        self.helper(root.left,t+root.val,arr,f)
        if root != None and root.right == None and root.left == None:
            if t+root.val == f:
                if root.val + t == f:
                    b = arr.copy()
                    self.out.append(b)
        self.helper(root.right,t+root.val,arr,f)
        arr.pop()
        