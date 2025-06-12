"""
Time - O(n * 2H)
Space -  O(n * 2H)
"""
class Solution:
    def pathSum(self, root: Optional[TreeNode], target: int) -> List[List[int]]:
        if not root:
            return []
        
        if not root.left and not root.right:
            return [[root.val]] if root.val == target else []
        
        paths = []
        for sub_path in self.pathSum(root.left, target - root.val) + self.pathSum(root.right, target - root.val):
            paths.append([root.val] + sub_path)
        
        return paths
