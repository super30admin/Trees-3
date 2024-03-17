#Time Complexity: O(n)
#Space Complexity: O(n) #Max leaf nodes in a tree is n/2

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        queue=collections.deque()
        if root is None:
            return True
        queue.append(root.left)
        queue.append(root.right)

        while(queue):
            left=queue.popleft()
            right=queue.popleft()
            if left is None and right is None:
                continue
            elif left is None or right is None:
                return False
            elif left.val==right.val:
                queue.append(left.left)
                queue.append(right.right)
                queue.append(left.right)
                queue.append(right.left)
            else:
                return False

        return True
        

#DFS Boolean based
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        return self.DFS(root.left, root.right)

    def DFS(self, left, right):
        if left is None and right is None:
            return True
        if (left is None and right is not None) or (right is None and left is not None):
            return False
        if left.val==right.val:
            return self.DFS(left.left, right.right) and self.DFS(left.right, right.left)
        else:
            return False
            