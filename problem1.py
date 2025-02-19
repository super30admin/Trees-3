'''
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []

        def findPathSum(node, path, currSum):
            if not node: return

            currSum += node.val
            path.append(node.val)
            if not (node.left or node.right):
                if currSum == targetSum:
                    result.append(list(path))
            
            findPathSum(node.left, path, currSum)
            findPathSum(node.right, path, currSum)
            path.pop()

        findPathSum(root, [], 0)
        return result