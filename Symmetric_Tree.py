#Time Complexity : O(N)
#Space Complexity: O(H)
#Yes it ran on leetcode


class Solution(object):
    def isSymmetric(self, root):
        return self.helper(root, root)

    def helper(self, r1, r2):
        if r1 == None and r2 == None:
            return True
        if r1 == None or r2 == None or r1.val != r2.val:
            return False

        return self.helper(r1.left, r2.right) and self.helper(r1.right, r2.left)
