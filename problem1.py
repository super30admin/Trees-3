"""
I first and explore paths, have a base case, the append the current node and check whether its is part of the target sum or not, if remaining sum and we have reached leaf node
we append the copy of the current path to the result list. Explore other options and backtrack by popping last element.
TC is O(N) and SC is o(height)
"""
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        res =[]
        def dfs( node, remaining, path):
            if not node:
                return None
            #do
            path.append(node.val)
            remaining -= node.val
            #check leaf and condition
            if not node.right and not node.left and remaining == 0:
                res.append(path[:]) #append copy of path
            #explore
            dfs(node.right, remaining, path)
            dfs(node.left, remaining, path)
            #undo pop
            path.pop()
        dfs(root, targetSum, [])
        return res
            

