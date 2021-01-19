# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Performing inorder traversal where once the I reach leaf node, I add it to the paths array

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        paths = []
        def traverse(root, sum_value, path):
            current_sum = sum_value + root.val
            if not root.left and not root.right:
                if current_sum == sum:
                    paths.append(path + [root.val])
            else:
                if root.left:
                    traverse(root.left, current_sum, path + [root.val])
                if root.right:
                    traverse(root.right, current_sum, path + [root.val])
            
        if root:
            traverse(root, 0, [])

        return paths