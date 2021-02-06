"""
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# Recursion
class Solution:
    result = []
    target = 0
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if not root: return []
        self.target = targetSum
        self.result = []
        self.helper(root, [root.val], root.val)
        
        return self.result
        
    def helper(self, node, path, currsum):
        # Base case
        if not node: return
        if node.left==None and node.right==None:
            if currsum == self.target:
                self.result.append(path)
            return
        
        # Logic
        if node.left:
            self.helper(node.left, path+[node.left.val], currsum+node.left.val)
        if node.right:
            self.helper(node.right, path+[node.right.val], currsum+node.right.val)
"""
 Backtracking Solution
 Time Complexity: O(n)
 Space Complexity: O(h)
"""
class Solution:
    result = []
    target = 0
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if not root: return []
        self.target = targetSum
        self.result = []
        self.helper(root, [], 0)
        
        return self.result
        
    def helper(self, node, path, currsum):
        
        if not node: return  # Base case        
        
        currsum += node.val  # Logic
        path.append(node.val)  # Action
        if node.left==None and node.right==None:
            if currsum == self.target:
                self.result.append(copy.deepcopy(path))
        
        # Recurse
        self.helper(node.left, path, currsum)  
        self.helper(node.right, path, currsum)
        
        # Backtrack
        path.pop()