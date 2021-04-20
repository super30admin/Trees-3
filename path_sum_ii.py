class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        self.res = []
        self.dfs(root, targetSum, 0, [])
        return self.res

    def dfs(self, root, target, curr, mylist: list):
        if not root:
            return
        curr = curr + root.val
        mylist.append(root.val)

        if curr == target and root.left == None and root.right == None:
            self.res.append(mylist[:])

        self.dfs(root.left, target, curr, mylist)
        self.dfs(root.right, target, curr, mylist)
        mylist.pop()