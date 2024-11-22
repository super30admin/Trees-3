# The code defines a pathSum method to find all root-to-leaf paths in a binary tree where the sum of the node values equals a given targetSum.

# Helper Function (treeTraversal):
#   - The treeTraversal function performs a depth-first traversal of the tree, keeping track of the current path and its sum.
#   - Base Case:
#       - If the current node is None, return immediately as there is no path to process.
#   - Recursive Case:
#       - Append the current node's value to 'lis', which represents the current path.
#       - Recursively call treeTraversal for the left and right child nodes to explore all paths.
#       - If the current node is a leaf (both left and right children are None):
#           - Calculate the sum of the current path stored in 'lis'.
#           - If the sum equals targetSum, add a copy of the current path to the result list 'res'.
#       - After processing the current node, remove its value from 'lis' to backtrack and explore other paths.

# Main Execution:
#   - The pathSum method initializes two lists:
#       - 'lis' to track the current path during traversal.
#       - 'res' to store all valid paths where the sum matches targetSum.
#   - It calls the treeTraversal function starting from the root node.
#   - Finally, it returns 'res', which contains all valid paths.

# TC: O(n) - Each node in the tree is visited once, making the time complexity linear in the number of nodes.
# SC: O(h) - The space complexity is proportional to the height of the tree due to the recursion stack and the path list 'lis'.


from typing import List, Optional


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        lis = []
        res = []
        def treeTraversal(root: Optional[TreeNode]):
            if root == None:
                return
            lis.append(root.val)
            treeTraversal(root.left)
            treeTraversal(root.right)
            if(root.left == None and root.right == None):
                sums = sum(lis)
                if(sums == targetSum):
                    res.append(lis.copy())
            lis.pop()
        treeTraversal(root)
        return res