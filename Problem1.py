# Time Complexity: O(N^2) - O(N/2) to grab all leaf - for each leaf path - copy path to result requires O(N/2)
# Space Complexity: O(H)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
      # Gen all paths to leaf
      # Filter for criteria 
      # Time Complexity: O(N)
      # Space Complexity: O(N + H)
      # res = []
      # def dfs(node, path):
      #   if not node:
      #     return
      #   if not node.left and not node.right:
      #     res.append(path + [node.val])
      #     return
      #   dfs(node.left, path + [node.val])
      #   dfs(node.right, path + [node.val])
      # dfs(root, [])
      # return list(filter(lambda path: sum(path) == targetSum, res)) 
      res = []
      def dfs(node, sum, path):
        if not node:
          return
        path.append(node.val)
        if not node.left and not node.right:  
          if sum + node.val == targetSum:
            res.append(list(path))
        else:
          dfs(node.left, sum + node.val, path)
          dfs(node.right, sum + node.val, path)
        path.pop()
      dfs(root, 0, [])
      return res


        
        
