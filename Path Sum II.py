# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : I don't know why nothing is being appended in self.ans


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum):
        
        self.target = sum
        print(self.target)
        self.ans = []
        self.traverse(root, [],0)
        return self.ans
        
    def traverse(self,node, path,curr):
        if node:
            curr += node.val
            if not node.left and node.right and self.target==curr:
                self.ans.append(path)
                
            self.traverse(node.left, path+[node.val],curr)
            self.traverse(node.right, path+[node.val],curr)
        