# Leetcode 113. Path Sum II

# Time Complexity :  O(n^2) due to creating copy at every node where n is the size of the array

# Space Complexity : O(n) where n is the size of the array

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: At every node we calculate the sum of nodes along the path until that node. If the path sun
# matches the target and we are at the leaf node then we append the path to the result array. Else we
# move down the tree with the updated path sum and copy of the current path

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        result = []
        path = []
        pathSum = 0
        if root == None:
            return result
        self.dfs(root,pathSum,path,result,sum)
        return result
    
    
    def dfs(self,root,pathSum,path,result,target):
        # Base condition
        if root == None:
            return 
        # Adding the node's value to the current sum
        pathSum += root.val
        # Updating the path with current node
        path.append(root.val)
        
        # If the node is a leaf and path Sum matches target then append path to the result array
        if pathSum == target and not root.left and not root.right:
            result.append(path)
        # Else recurssively go down the left and right child with copy of the current path
        else:        
            self.dfs(root.left,pathSum,path.copy(),result,target)
            self.dfs(root.right,pathSum,path.copy(),result,target)