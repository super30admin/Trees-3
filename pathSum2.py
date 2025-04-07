'''
We recursively explore each node in the tree and accumulate the node values in the current path.
When a leaf node is reached, we check if the accumulated sum equals the target sum and, if so, add the path to the result.
After exploring both left and right subtrees, we backtrack by removing the last node from the path.

Time Complexity: O(n)
Space Complexity: O(h+k)
'''
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []

        def helper(node, arr, curSum):
            if not node: 
                return
            
            curSum += node.val
            arr.append(node.val)

            if not node.left and not node.right and curSum == targetSum:
                result.append(list(arr))

            helper(node.left, arr, curSum)
            helper(node.right, arr, curSum)

            arr.pop()

        helper(root, [], 0)
        return result