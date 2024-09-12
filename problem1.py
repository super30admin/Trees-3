# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


#Recursive approach
class Solution:
    def __init__(self):
        # Result as a global variable to store final result
        self.result = []
        
    def helper(self, node,pathsum, path):

        # If pathsum comes down to 0 and we have reach the leaf node we add the root-leaf path to result
        if pathsum == 0 and node.left == None and node.right== None:
            self.result.append(path)
            return

        # Traverse left and right in Depth First Manner
        if node.left!= None:         
                self.helper(node.left, pathsum - node.left.val, path+[node.left.val])
                 
        if node.right!=None:       
                self.helper(node.right, pathsum - node.right.val, path+[node.right.val])
            
       
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if root == None:
            return []
        path = []
        path.append(root.val)
        sum = sum - root.val
        self.helper(root, sum, path)
        return self.result
        
        
        