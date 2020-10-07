# Time complexity : O(n). Because we traverse the entire input tree once, the total run time is O(n), where n is the total number of nodes in the tree.
# Space complexity : The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in O(n). Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Already solved this earlier

# 1. see whether two values of children are same or not
# 2. see whether right subtree is opposite of left subtree.
# 3. in short, on every node (l) we have to check that whether left of it is same as right of node in that side of tree (r) and vice versa


class Solution(object):
    def isSymmetric(self, root):
        
        def helper(l,r):
            if not l and not r:
                return True
            if not l or not r:
                return False
            return l.val==r.val and helper(l.left,r.right) and helper(l.right,r.left)
        
        return helper(root,root)