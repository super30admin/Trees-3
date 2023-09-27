# TC: O(n2)
#SC : O(n2)
class Solution:
    def pathSum(self, root, targetSum):
        
        def dfs(root, r_summ, arr, result):
            if not root:
                return
            arr.append(root.val)

            if r_summ == root.val and not root.left and not root.right:
                result.append(list(arr))
            else:
                dfs(root.left, r_summ - root.val, arr, result)
                dfs(root.right, r_summ - root.val, arr, result)
            arr.pop()
        result = []
        dfs(root, targetSum, [], result)
        return result 