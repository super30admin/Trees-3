# Time Complexity :
#O(N)

# Space Complexity :  
# O(H)  ,  H = height of tree, recursion creates a stack where all nodes upto the left most child will be stored at max. 


# Approach:
# DFS Approach. Take global variables to store "ans" and "path".
# Recursvily update currSum and only append the currSum to ans, if the root-to-leaf node sum is equal to targetSum



class Solution(object):
    def __init__(self):
        self.ans = []    # to store all root-to-leaf path
        self.path = []    # single root-to-leaf path

    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        
        self.dfs(root, targetSum, 0)

        return self.ans
    
    def dfs(self, root, targetSum, currSum):
        if not root:
            return
        
        currSum = currSum + root.val
        self.path.append(root.val)

        if not root.left and not root.right:
            if currSum == targetSum:
                self.ans.append(list(self.path))
        
        self.dfs(root.left, targetSum, currSum)
        self.dfs(root.right, targetSum, currSum)

        self.path.pop()
    