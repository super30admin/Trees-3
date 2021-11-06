# Leetcode 113: Path Sum 2
# Time - O(n)
# Space - O(n)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        result = []
        
        def helper(root, targetSum, currSum, currArray):
            
            if root is None:
                
                return
            
            if root.left is None and root.right is None and root.val + currSum == targetSum:
                
                currArray.append(root.val)
                result.append(currArray.copy())
                currArray.pop()
                
            
            currSum = currSum + root.val
            currArray.append(root.val)
            
            helper(root.left, targetSum, currSum, currArray)
            helper(root.right, targetSum, currSum, currArray)
            
            
            currArray.pop()     
        
        
        helper(root, targetSum, 0, [])
        
        return result