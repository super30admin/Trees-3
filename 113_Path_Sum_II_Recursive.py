# Time Complexity : O(n) [n = number of nodes in tree]
# Space Complexity : O(n * h) [h = height of tree, n = number of nodes in tree] -> At all nodes a new list a created for recursive call
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. Traverse the tree in DFS manner and pass the sum and node value list in each recursive call
# 2. As soon as the traversal hits the leaf node check if it is equal to target
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res = []
        def helper(root, target, curr_sum, curr_list):
            nonlocal res
            ## base
            if root is None:
                return
            if root.left is None and root.right is None:
                if curr_sum+root.val == target:
                    new_list = [num for num in curr_list]
                    new_list.append(root.val)
                    res.append(new_list)
                return
            
            ## body
            new_left_list = [num for num in curr_list]
            new_left_list.append(root.val)
            helper(root.left, target, curr_sum+root.val, new_left_list)
            new_right_list = [num for num in new_left_list]
            helper(root.right, target, curr_sum+root.val, new_right_list)
        helper(root, sum, 0, [])
        return res