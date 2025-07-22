#time complexity: O(n) -> Need to travel to all th enodes
#spade complexity: O(h) -> h:height of the tree
                        #-> Due to recursion stackj and path list 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        def dfs(node, path, sum) -> List[List[int]]:
            if not node:
                return 
            #Adding current node val to path and sum
            path.append(node.val)
            sum += node.val

            #if its a leaf node and sum matches the target sum then add the path to the resulkt
            if not node.left and not node.right and sum == targetSum:
                result.append(list(path))
            
            #check left and right subtree
            dfs(node.left, path, sum)
            dfs(node.right, path, sum)

            path.pop()
        dfs(root, [], 0)
        return result




            
        
