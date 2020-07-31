"""
Problem:
https://leetcode.com/problems/path-sum-ii/

Approach:

1. Kep 2 global variables result and target. result will be our output array and traget is given sum
2. visit the trees in pre-order fashion and at each root node caluclate the current sum and keep a local array whihc ontains the elements in the path of the tranversal
3. when we reach leaf node, compiar the current sum with target and if its equal, append the local array to the global result
4. return the global result array

"""

# Time Complexity : O(n^2) 
# Space Complexity : O(n*h) where h is height of the tree = log(n) 
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    result = []
    target = 0
    
    def helper(self,root, currentSum, localArray):
        # base case
        if root == None:
            return  
        currentSum  = currentSum + root.val
        localArray.append(root.val)
      
        #logic
        if root.left==None and root.right==None:
            if currentSum==self.target:
                self.result.append(localArray.copy())
        
        self.helper(root.left,currentSum,localArray.copy())
        self.helper(root.right,currentSum,localArray.copy())
    
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        self.target = sum
        if root==None:
            return self.result
        self.helper(root,0,[])
        return self.result