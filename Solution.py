class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        time: O(n)
        space: O(height)
        """
        self.result = []
        def helper(t, cur_path=[], cur_sum=0):
            if not t:
                return
            cur_sum += t.val
            cur_path.append(t.val)
            if not t.left and not t.right:
                if cur_sum == targetSum:
                    self.result.append(cur_path[:])            
            helper(t.left, cur_path, cur_sum)            
            helper(t.right, cur_path, cur_sum)
            
            cur_path.pop()
        helper(root)
        return self.result

    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        time: O(n)
        space: O(height)
        """
        def helper(left, right):
            if not left and not right:
                return True
            elif not left or not right:
                return False
            return left.val == right.val and helper(left.left, right.right) and helper(left.right, right.left)
        
        return helper(root.left, root.right)