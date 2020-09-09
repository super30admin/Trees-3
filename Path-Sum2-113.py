# Time Complexity : O(n2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach 

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        def helper(root, sum):
            if root is None:
                return
            if root.left is None and root.right is None and sum - root.val == 0:
                self.res.append(root.val)
                self.ans.append(tuple(self.res))
                self.res.pop()
                return
            if root.left is None and root.right is None and sum != 0:
                return
            self.res.append(root.val)
            helper(root.left, sum - root.val)
            helper(root.right, sum - root.val)
            self.res.pop()
            return
        
        self.res = []
        self.ans = []
        helper(root,sum)
        return self.ans
