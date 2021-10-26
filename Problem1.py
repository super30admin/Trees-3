
#Time Complexity : O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        if not root:
            return self.res
        def dfs(node, path, curSum):
            curSum +=node.val
            temp = path+[node.val]
            if node.left:
                dfs(node.left,temp, curSum)
            if node.right:
                dfs(node.right,temp, curSum)
            if not node.left and not node.right and curSum ==targetSum:
                self.res.append(temp)
                
        dfs(root, [], 0)
        return self.res
