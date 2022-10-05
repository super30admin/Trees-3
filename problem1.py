#Path sum 2
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(node, sm):
            if not node: return []
            if not node.left and not node.right and sm == node.val:
                return [[node.val]]
           
            lft = dfs(node.left, sm - node.val)
            rgh = dfs(node.right, sm - node.val)
            return [cand + [node.val] for cand in lft + rgh]
            
        return [s[::-1] for s in dfs(root, targetSum)]