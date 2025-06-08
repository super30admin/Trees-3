#Time Complexity: O(N^2)
#Space Complexity: O(H) or O(logN) Height of the binary tree, Recursive call stack

class Solution(object):

    def __init__(self):
        self.paths_list = []

    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """

        currentSum = 0
        

        def getallPaths(root, currentSum, path):

            if root is None:
                return
            
            currentSum += root.val
            path.append(root.val)

            getallPaths(root.left, currentSum, path)
            
            if root.left is None and root.right is None:
                if currentSum == targetSum: 
                    self.paths_list.append(path[:])

            getallPaths(root.right, currentSum, path)

            #backtrack 
            path.pop()

        
        getallPaths(root, currentSum, [])

        return self.paths_list










        