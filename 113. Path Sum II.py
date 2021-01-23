# // Time Complexity : O(n^2)
# // Space Complexity : O(n^2)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
# // Your code here along with comments explaining your approach
	# Travers every node and maintain a cumillative sum and return the mainted path at that point if the sum is 
	# equivalent to the target value.
	

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.res = []
        self.target = 0
        
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if root == None:
            return self.res
        self.target = targetSum
        self.helper(root,0,[])
        return self.res
    
    def helper(self,Node,CurrSum,Path):
        if Node == None:
            return 
        CurrSum += Node.val
        Path.append(Node.val)
        if CurrSum == self.target:
            if Node.left == None and Node.right == None:
                self.res.append(Path)
        
        self.helper(Node.left,CurrSum,Path.copy())
        self.helper(Node.right,CurrSum,Path.copy())

#Using BackTracking
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.res = []
        self.target = 0
        
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if root == None:
            return self.res
        self.target = targetSum
        self.helper(root,0,[])
        return self.res
    
    def helper(self,Node,CurrSum,Path):
        if Node == None:
            return 
        CurrSum += Node.val
        Path.append(Node.val)
        if CurrSum == self.target:
            if Node.left == None and Node.right == None:
                self.res.append(Path.copy())
        
        self.helper(Node.left,CurrSum,Path)
        self.helper(Node.right,CurrSum,Path)
        Path.pop()