# Time Complexity: O(N)
# Space Complexity: O(H) where H is the height of the tree
# Were you able to solve this on your own? Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []

        if not root:
            return []

        def dfs(root: TreeNode, target: int, path: List[int]):
 
            # base case
            if not root:
                return None

            # add current node value to the path
            path.append(root.val)

            # if leaf node is reached, check if the target is met 
            if not root.left and not root.right:
                # add current path to result if target is met
                if root.val == target:
                    self.res.append(list(path))
                    
            # pass the remaining targt and current path along with the left and right subtree
            # target is reduced by the current node value
            # this is to check if the remaining sum can be achieved by the left or right subtree
            
            # recursively traverse left subtree
            dfs(root.left, target-root.val, path)

            # recursively traverse right subtree
            dfs(root.right, target-root.val, path)
            
            # backtrack to remove the current node from the path
            path.pop()

            
        dfs(root, targetSum, [])

        return self.res

