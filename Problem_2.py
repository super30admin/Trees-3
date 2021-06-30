# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        return self.isMirror(root, root)
    
    def isMirror(self, root1: TreeNode,  root2: TreeNode) -> bool:
        if root1 == None and root2 == None:
            return True
        if root1 == None or root2 == None:
            return False
        return root1.val == root2.val and self.isMirror(root1.left, root2.right) and self.isMirror(root1.right, root2.left)

# Time Complexity : O(n)
# Space Complexity : O(h)


# BFS Solution

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        q = deque()
        q.append(root)
        q.append(root)
        while len(q) != 0:
            curr1 = q.popleft()
            curr2 = q.popleft()
            if curr1 == None and curr2 == None:
                continue
            if curr1 == None or curr2 == None:
                return False
            if curr1.val != curr2.val:
                return False
            q.append(curr1.left)
            q.append(curr2.right)
            q.append(curr1.right)
            q.append(curr2.left)
        return True

# Time Complexity: O(n)
# Space Complexity: O(n/2)