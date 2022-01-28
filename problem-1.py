# Leetcode Execution: YES
# Time Complexity: O(n)
# Space Complexity:O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.arr=[]
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        # here we explore DFS. recursively reach leaf node and sum equals target. then we add that numbers to the static array 
        # if the root has no children we return [root.val ] if the root is equal to sum 
        
        
        
        if root==None: 
            return []
        elif root.left==None and root.right==None:
            if root.val==targetSum:
                return [[root.val]]
            
            
            
        # we calculate left tree abd rigt tree independently 
        
        self.helper(root.left, [root.val], root.val, targetSum)
        self.helper(root.right, [root.val], root.val, targetSum)
        return self.arr
    def helper(self, root, ar,tsum, target):
        
        
        if root==None:
            return
        
        # we add each number to sum and check if it is equal sum 
        tsum+=root.val
        ar.append(root.val)
       
        if target==tsum and root.left==None and root.right==None:
            self.arr.append(ar)
            return 
        # then recursively call left and right tree
        self.helper(root.left, list(ar), tsum, target)
        self.helper(root.right, list(ar), tsum,target)
