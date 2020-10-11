# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach
class Solution:
    def helper(self, node, remainingSum, pathNodes, pathsList):
            if not node:
                return
            
            pathNodes.append(node.val)
            
            if remainingSum == node.val and not node.left and not node.right:
                pathsList.append(list(pathNodes))
            else:
                self.helper(node.left, remainingSum - node.val, pathNodes, pathsList)
                self.helper(node.right, remainingSum - node.val, pathNodes, pathsList)
            
            pathNodes.pop()
                
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        pathsList = []
        self.helper(root, sum, [], pathsList)
        return pathsList
