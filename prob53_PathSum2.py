#Time Complexity :o(n2)
# Space Complexity :o(n)
# Did this code successfully run on Leetcode : yes
 
 class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
                result = []
        
                self.dfs(root, targetSum, [], result)
                return result
        
    def dfs(self, node, target, path, result):
        if not node: return
        
        target -= node.val
        
        # add node to the current path explored
        path.append(node.val)
        
        if not node.left and not node.right and target == 0:
            result.append(path.copy())
            
        # explore left and right chilren if any
        self.dfs(node.left, target, path, result)
        self.dfs(node.right, target, path, result)
        
        path.pop()