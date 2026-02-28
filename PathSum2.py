# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        
        # Global list to keep a track of the paths.
        self.res = []

        def helper(root, path, total):
            if not root:
                return

            path.append(root.val)
            total += root.val

            if total == targetSum:
                if not root.left and not root.right:
                    # Make a deep copy and attach to the list.
                    self.res.append([i for i in path])
                    #Pop the current node as it has been processed.
                    path.pop()
                    return

            helper(root.left, path, total)
            helper(root.right, path, total)
            # Make sure to path the current node as it has been processed.
            path.pop()

            return
        helper(root, [], 0)
        return self.res

    #TC : O(n)
    #SC : O(n)