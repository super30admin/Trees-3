# Time Complexity : O(N)  //Where n is the size of the array
#  Space Complexity : O(H)  //Recursive stack for the tree
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        path = []
        
        #Base Case
        if not root:
            return []
        #Declare a function to iterate through the tree
        def dfs(root,curr):
            #we found a leaf
            if not root.left and not root.right:
                curr+=[root.val]
                path.append(curr)
                return
            if root.left:
                dfs(root.left,curr+[root.val])
            if root.right:
                dfs(root.right,curr+[root.val])
        dfs(root,[])
        #Declare the variable and add up
        res = []
        for li in path:
            if sum(li)==targetSum:
                res.append(li)
        return res