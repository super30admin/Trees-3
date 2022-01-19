# // Time Complexity : O(n) where n is the number of nodes in the graph.
# // Space Complexity : O(h) where h is the height of the tree. [Used for path array]
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.target = targetSum
        
        def helper(root,currentSum, path):
            if root == None:
                return
            currentSum =  currentSum + root.val
            path.append(root.val)
            if root.left == None and root.right == None:
                if currentSum == self.target:
                    path_to_add = list(path)
                    self.result.append(path_to_add)
            helper(root.left,currentSum,path)
            helper(root.right,currentSum,path)
            path.pop()
            return
        # l = []
        helper(root,0,[])
        return self.result
