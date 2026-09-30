# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Three approaches to solve the path sum 2 problem
# First is iterative approach where we add root to stack along with its value and path initially empty list then add left and right nodes
# Once we reach leaf node we check if the sum is equal to target sum then we add path to result
# Second approach is recursion where we create a new list every time for the path we recurse until leaf node and if it matches the target sum we add that to path
# Backtracking where we keep using the same path list and remove the node once it reaches leaf to explore other paths. when we find a valid path we add it to res

class Solution:
    def pathSum(self, root: TreeNode | None, targetSum: int) -> List[List[int]]:
        if not root:
            return []
        res = []
        def preorder(root):
            stack = [(root, 0, [])]
            while stack:
                node, num, path = stack.pop()
                if node:
                    num = num + node.val
                    path = path + [node.val]
                    if not node.left and not node.right:
                        if num == targetSum:
                            res.append(path)
                    if node.left:
                        stack.append((node.left, num, path))
                    if node.right:
                        stack.append((node.right, num, path))

            return res
        output = preorder(root)
        return output
'''Iterative solution using stack'''  

class Solution:
    def pathSum(self, root: TreeNode | None, targetSum: int) -> List[List[int]]:
        if not root:
            return []
        return self.helper(root, 0, [], targetSum)

    def helper(self, root, num, path, targetSum):
        if not root:
            return []

        num = num + root.val
        path = path + [root.val]

        if root.left is None and root.right is None:
            if num == targetSum:
                return [path]
            return []
        return self.helper(root.left, num, path, targetSum) + self.helper(root.right, num, path,targetSum)
# Recursive

class Solution:
    def pathSum(self, root: TreeNode | None, targetSum: int) -> List[List[int]]:
        if not root:
            return []
        res = []
        self.helper(root, 0, [], targetSum, res)
        return res

    def helper(self, root, num, path, targetSum, res):
        if not root:
            return []

        num = num + root.val
        path.append(root.val)

        if root.left is None and root.right is None:
            if num == targetSum:
                res.append(path.copy())
        else:
            self.helper(root.left, num, path, targetSum, res)
            self.helper(root.right, num, path,targetSum, res)
    
        path.pop()

# Backtracking
