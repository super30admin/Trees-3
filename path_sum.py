class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root == None:
            return []
        self.result = []
        self.dfs(root, 0, [], targetSum)
        return self.result
    def dfs(self, root: Optional[TreeNode], currSum: int, path: List[int], targetSum : int) -> None:
        if root == None:
            return

        currSum = currSum + root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.result.append(path)
            return
        self.dfs(root.left, currSum, [i for i in path], targetSum)
        self.dfs(root.right, currSum, [i for i in path], targetSum)

# Time complexity - O(n)
# Space complexity - O(h)