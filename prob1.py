# Time Complexity :O(n)
# Space Complexity :O(h) - height of tree
# Leet Code: Yes

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        def helper(root, arr, targetSum):
            if root is None:
                return
            arr.append(root.val)
            s = sum(arr)
            if root.left == None and root.right == None and s == targetSum:
                newArr = arr[:]
                res.append(newArr)
            
            helper(root.left, arr[:], targetSum)
            helper(root.right, arr[:], targetSum)
            #backtracking
            arr.pop()

        helper(root, [], targetSum)
        return res