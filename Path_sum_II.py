#Time Complexity : O(N*N)
#Space Complexity: O(N * H)
#Yes it ran on leetcode


class Solution(object):
    def pathSum(self, root, sum):
        global res
        res = []
        global target
        target = sum
        if root == None:
            return res
        self.dfs(root, 0, [])
        return res

    def dfs(self, root, currsum, temp):
        global res
        global target
        if root == None:
            return
        currsum += root.val
        temp.append(root.val)

        if root.left == None and root.right == None:
            if currsum == target:
                res.append(list(temp))

        self.dfs(root.left, currsum, list(temp))
        self.dfs(root.right, currsum, list(temp))

