#Time Complexity: O(n)
#Space Complexity: O(h) where h is the height of the BT
#Works on leetcode: yes
#Approach: To check if the BT is symmetric, we need to see all the subtrees are mirror image of each other. For that, we 
#keep stack of left and right nodes and append the pair wise left.left & right.right and left.right and right.left whenever
#left.val is equal to right.val 
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        stack = [(root.left, root.right)]
        while stack:
            l,r = stack.pop()
            if not l and not r:
                continue
            if not l or not r:
                return False
            if l.val==r.val:
                stack.append((l.left, r.right))
                stack.append((l.right, r.left))
            else:
                return False
        return True