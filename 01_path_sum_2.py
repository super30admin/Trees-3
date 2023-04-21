'''
Approach:
---------
will do DFS and go until we find the leaf node and check if the sum of the path is equal to target sum.
If it is equal then add to paths if not then pop from the path array and backtrack


Complexity Analysis:
--------------------
TC: O(n) since we will visit all nodes
SC: O(H) we will have recursive stack equal to the height of the tree 

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root == None:
            return
        
        paths = []
        
        
        def dfs(node, path):
            if node == None:
                return None
            path.append(node.val)
            
            if node.left == None and node.right==None:
                if sum(path) == targetSum:
                        paths.append(path.copy())
            else:
                dfs(node.left, path)
                dfs(node.right, path)
            
            path.pop()
                
            return paths
        
        return dfs(root, [])
                    
        