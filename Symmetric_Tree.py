# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
#First Approach Iterative where we check if root is none then we found no tree so return true
#If there is a tree and left and right nodes then we add them to stack. Then we pop the nodes and check its value if it matches that means it is symmetric
#We will do the same process until we reach leaf where both left and right are none. If one is none return false
#The tree should be a mirror of left and right side so we comapre left.left with right.right and left.right with right.left
#Second Approach recursive where we have a helper function which returns True if both values are same

class Solution:
    def isSymmetric(self, root: TreeNode | None) -> bool:
        if not root:
            return True
        stack = [(root.left, root.right)]
        while stack:
            left, right = stack.pop()
            if left is None and right is None:
                continue
            if left is None or right is None:
                return False
            if left.val != right.val:
                return False

            stack.append((left.left, right.right))
            stack.append((left.right, right.left))
        return True
'''Iterative Solution'''

class Solution:
    def isSymmetric(self, root: TreeNode | None) -> bool:
        if root is None:
            return True
        return self.helper(root.left, root.right)

    def helper(self, left, right):
        if left is None and right is None:
            return True
        if left is None or right is None:
            return False
        if left.val != right.val:
            return False
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
#Recursion

from collections import deque
class Solution:
    def isSymmetric(self, root: TreeNode | None) -> bool:
        if root is None:
            return True
        queue = deque([(root.left, root.right)])
        while queue:
            left, right = queue.popleft()
            if left is None and right is None:
                continue
            if left is None or right is None or left.val != right.val:
                return False
            queue.append((left.left, right.right))
            queue.append((left.right, right.left))
        return True
#BFS
                
                

        