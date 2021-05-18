class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        stack = []
        final = []
        currSum = 0
        currPath = []
        while stack or root:
            while root:
                currSum += root.val
                currPath.append(root.val)
                stack.append((root, currSum, list(currPath)))
                root = root.left
            
            root, cSum, tempPath = stack.pop()
            currPath = tempPath.copy()
            currSum = sum(currPath)
            
            if not root.right and not root.left and cSum == targetSum:
                temp_list = []
                temp_list = tempPath.copy()
                final.append(temp_list)
            root = root.right
        
        return final
                
