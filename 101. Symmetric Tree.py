# Time: O(n)
# Space: O(h)

# DFS APPROACH

# In the DFS approach we pair the left.left with right.right and left.right with right.left so as to check the mirroring
# If both left and right are not there then return True
# And if one of them is not there or their values are not equal then return False
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root: return True
        return self.helper(root.left, root.right)
    def helper(self,left,right):
        if not left and not right:
            return True
        if not left or not right or left.val != right.val:
            return False
        l = self.helper(left.left,right.right)
        r = self.helper(left.right,right.left)

        return l and r
    

# Time: O(n)
# Space: O(n)

# BFS APPROACH

# Here in the BFS approach we add the elements as left.left first and then add right.right so that we can check it in pairs
# While removing from the queue we remove 2 elements at a time and check if they are not equal or one of them is None in that case we return False
# And if both of them (left and right) are None then we continue to the next loop.
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q = deque([root.left,root.right])

        while q:
            left = q.popleft()
            right = q.popleft()

            if not left and not right:
                continue
            if not left or not right or left.val != right.val:
                return False

            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)

        return True