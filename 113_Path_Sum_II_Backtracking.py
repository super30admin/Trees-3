# Time Complexity : O(n) [n = number of nodes in tree]
# Space Complexity : O(n * h) [h = height of tree, n = number of nodes in tree] ->  All the leaves result into target sum and there are (n/2) leaves in a full binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. Traverse the tree in DFS manner and pass the sum and node value list in each recursive call
# 2. As soon as the traversal hits the leaf node check if it is equal to target
# 3. Backtrack to previous state of the list after finishing the recusive call
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
            
            # action
            curr_list.append(root.val)
            
            # recurse
            helper(root.left, target, curr_sum+root.val, curr_list)
            helper(root.right, target, curr_sum+root.val, curr_list)
            
            # backtrack
            curr_list.pop()
        helper(root, sum, 0, [])
        return res