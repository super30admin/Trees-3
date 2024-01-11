#Time Complexity: O(n)
#Space Complexity: O(h)
#submit on leetcode: yes

# Definition for a binary tree node.

class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def pathSum(self, root: [TreeNode], targetSum: int) -> list[list[int]]:
        result = []
        self.helper_fun(root, targetSum, [], result)
        return result
    
    def helper_fun(self, root, remaining_sum, path, result):
        if not root:
            return None
        
        if not root.left and not root.right and remaining_sum == root.val:
            result.append(path + [root.val])
            return None

        self.helper_fun(root.left, remaining_sum - root.val, path + [root.val], result)
        self.helper_fun(root.right, remaining_sum - root.val, path + [root.val], result)
        

sol = Solution()

tree_root = TreeNode(5)
tree_root.left = TreeNode(4)
tree_root.right = TreeNode(8)
tree_root.left.left = TreeNode(11)
tree_root.left.left.left = TreeNode(7)
tree_root.left.left.right = TreeNode(2)
tree_root.right.left = TreeNode(13)
tree_root.right.right = TreeNode(4)
tree_root.right.right.right = TreeNode(1)

# Check paths with the sum 22
result = sol.pathSum(tree_root, 22)

# Print the result
print("Paths with the sum 22:", result)
        