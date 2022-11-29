#TC: O(n2)
#SC: O(n)
import copy
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root: return []
        
        def dfs(root,cur_nodes,cur_sum):
            cur_sum+=root.val
            cur_nodes.append(root.val)
            if not root.left and not root.right:
                nonlocal targetSum,ans
                if cur_sum==targetSum: ans.append(copy.deepcopy(cur_nodes))
            if root.left: dfs(root.left,cur_nodes,cur_sum)
            if root.right: dfs(root.right,cur_nodes,cur_sum)
            cur_nodes.pop()

        ans=[]
        dfs(root,[],0)

        return ans