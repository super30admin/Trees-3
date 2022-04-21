# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
    
#     def recurseTree(self, node, remainingSum, pathNodes, pathsList):
        
#         if not node:
#             return 
        
#         # Add the current node to the path's list
#         pathNodes.append(node.val)
        
#         # Check if the current node is a leaf and also, if it
#         # equals our remaining sum. If it does, we add the path to
#         # our list of paths
#         if remainingSum == node.val and not node.left and not node.right:
#             pathsList.append(list(pathNodes))
#         else:    
#             # Else, we will recurse on the left and the right children
#             self.recurseTree(node.left, remainingSum - node.val, pathNodes, pathsList)
#             self.recurseTree(node.right, remainingSum - node.val, pathNodes, pathsList)
            
#         # We need to pop the node once we are done processing ALL of it's
#         # subtrees.
#         pathNodes.pop()    
    
#     def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
#         pathsList = []
#         self.recurseTree(root, sum, [], pathsList)
#         return pathsList

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        def helper( root, temp , targetSum , result ): 
            if not root:
                return 
            temp.append(root.val)
            if targetSum ==  root.val and not root.left and not root.right : # leaf and reached targetSum
                result.append( list(temp) )
            if root.left : 
                helper( root.left, temp  , targetSum-root.val , result )
            if root.right and root.right.val <= targetSum : 
                helper( root.right, temp , targetSum - root.val , result )
            temp.pop()
            
        result = [] 
        temp = []
        # print("temp",temp)
        helper(root, [] , targetSum , result)
        return result
