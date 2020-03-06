
class TreeNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

class Solution:

    # Recursive Solution
    # time : O(N)
    # space = O(1) + Recursive Call Stack
    def symmetricTree(self, root):
        if root == None:
            return True
        return self.helper(root.left, root.right)

    def helper(self, left, right):
        # BASE CASE
        if left == None and right == None:
            return True
        if left == None or right == None or left.key != right.key:
            return False

        # LOGIC
        val1 = self.helper(left.left, right.right)
        val2 = self.helper(left.right, right.left)
        return val1 and val2


    # Iterative Solution
    # time : O(N)
    # space = O(H), H is height of Tree
    def symmetricTree(self, root):
        if root == None:
            return True
        q = [(root.left, root.right)]
        while q != []:
            left, right = q.pop(0)
            if left == None and right == None:
                return True
            if left == None or right == None or left.key != right.key:
                return False
            q.append((left.left, right.right))
            q.append((left.right, right.left))
        return True




a = TreeNode(20)
a.left = TreeNode(15)
a.right = TreeNode(15)
a.left.left = TreeNode(13)
a.left.right = TreeNode(14)
a.right.left = TreeNode(14)
a.right.right = TreeNode(13)


obj = Solution()
print(obj.symmetricTree(root = a))