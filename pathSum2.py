#Time Complexity: O(n)
#space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.res = []
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper(root, 0, [], targetSum)
        return self.res
    
    def helper(self, root, currSum, path, tgt):
        #base
        if root is None:
            return
        
        #logic
        currSum += root.val
        path.append(root.val)
        
        self.helper(root.left, currSum, path, tgt)
        
        if root.left is None and root.right is None:
            if currSum == tgt:
                print(path)
                self.res.append(path.copy())
        
        self.helper(root.right, currSum, path, tgt)
        del path[-1]
        
        
