"""
// Time Complexity : O(n)
// Space Complexity : O(h) -> height of tree, in the worst case if it is a skewed tree it will be O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

Since we are trying to find if the tree is symmetric we can treat the tree as two trees. We can use a helper function
and send in the root twice. We label them as node1 and node2. If both of them are none we return True. If both of them are false
we return False. If  one of them is False we return False. We must recrusively return if the node1 val and node2 val and recurse
on the left and the right
"""
class Solution(object):
    def isSymmetric(self, root):
        self.helper(root, root)
    def helper(self, node1, node2):
        if node1 == None and node2 == None:
            return True
        if node1 == None or node2 == None:
            return False
        return node1.val == node2.val and self.helper(node1.left, node2.right) and self.helper(node1.right, node2.left)