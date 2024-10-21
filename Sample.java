// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//101. Symmetric Tree
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None): //DFS T.C->O(N),S.C->O(H)
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    flag = True
    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        self.flag = True
        self.dfs(root.left,root.right)
        return self.flag
    def dfs(self,left,right):
        if left == None and right == None:
            return
        if left == None or right == None:
            self.flag = False
            return
        if left.val != right.val:
            self.flag = False
            return
        self.dfs(left.left,right.right)
        self.dfs(left.right,right.left)

//BFS
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object): //T.C->O(N),S.C->O(N/2)
    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        queue = deque()
        queue.append(root.left)
        queue.append(root.right)

        while len(queue) != 0:
            left = queue.popleft()
            right = queue.popleft()

            if left == None and right == None:
                continue
            if left == None or right == None:
                return False
            if left.val != right.val:
                return False
            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)
        return True
        