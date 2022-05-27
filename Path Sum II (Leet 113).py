# Time Complexity: O(N)
# Space Complexity: O(H), where H is height of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = list()
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        path = []
        self.helper(root,0,path,targetSum)
        return self.result
    
    def helper(self, root, cursum, path, targetSum):
        if root is None:
            return
        path.append(root.val)
        cursum += root.val
        if root.left is None and root.right is None:
            if cursum == targetSum:
                p = path.copy()
                self.result.append(p)
                
        
        self.helper(root.left, cursum, path, targetSum)
        self.helper(root.right, cursum, path, targetSum)
        path.remove(path[-1])
        