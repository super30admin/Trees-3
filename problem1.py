# Time Complexity : O(n^2)
# Space Complexity : O(HN)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 
# Your code here along with comments explaining your approachclass Solution:

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def search(node, p, s):
            if node:
                if not node.left and not node.right and s + node.val == targetSum:
                    self.res.append(p + [node.val])
                search(node.left, p + [node.val], s + node.val)
                search(node.right, p + [node.val], s + node.val)
        
        self.res = []
        search(root, [], 0)
        return self.res