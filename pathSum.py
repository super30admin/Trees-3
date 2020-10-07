class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        """
        Time Complexity: O(N)
        We are travesing all the nodes to explore sum, there might be  some nodes with skipped when calculating sum greater than givenb sum
        
        Space Complexity: O(N)
        Accepted.
        """

        result = []
        
        def dfs(node, path, currSum):
            if node:
                currSum+=node.val
                if node.left == None and node.right==None and currSum == sum:
                    path.append(node.val)
                    result.append(path)
                if node.left:
                    dfs(node.left, path+[node.val], currSum)
                if node.right:
                    dfs(node.right, path+[node.val], currSum)
        
        dfs(root, [], 0)
        return result