# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# we got left and right from root
# check if values of both root are null adn return true
# if one of them has None return False
# if both do not match then return False
# call helper by anding left and right call

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root: return True
        return self.helper(root.left, root.right)
    
    def helper(self, one, two):
        if one == None and two == None:
            return True
        if one == None or two == None:
            return False
        if one.val != two.val:
            return False
        return self.helper(one.left, two.right) and self.helper(one.right, two.left)
        
