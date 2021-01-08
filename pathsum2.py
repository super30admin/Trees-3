class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        '''
        Time compolexity = O(logn)
        Space complexity = O(logn)
        if node is leaf node and sum == target:
            add that path to ans
        else explore till the leaf using DFS
        '''
        if root == None:
            return []
        res = []

        def dfs(root,path,cursum):
            if root.left == None and root.right == None and sum == cursum:
                res.append(path)
            if root.left : dfs(root.left,path + [root.left.val],cursum + root.left.val)
            if root.right : dfs(root.right,path + [root.right.val],cursum + root.right.val)
        dfs(root,[root.val],root.val)
        return res