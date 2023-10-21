# Time Complexity : O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        def helper(root, targetSum, currsum, path):
            if not root:
                return
            currsum+=root.val
            path.append(root.val)
            if(root.left == None and root.right == None):
                if(currsum==targetSum):
                    result.append(list(path[:]))
            helper(root.left, targetSum, currsum, path)
            helper(root.right, targetSum, currsum, path)
            path.pop(len(path)-1)
        result=[]
        helper(root, targetSum, 0, [])
        return result
        