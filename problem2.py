'''
Recursive
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation (Recursive): Check if we are leaf node if both trees creates are in leaf node, they are symetric, if one is not then
return false, move recursively for A.left, B.right and B.left and A.right.

Iterative:
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation (Recursive): Create a queue and add the root.left and root.right elements in the queue and check if the two sides are equal
or not, pop 2 values each and check till queue is empty. If empty they are symemtric.
'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def helper(self, rootA: TreeNode, rootB: TreeNode) -> bool:
        if rootA == None and rootB == None:
            return True

        if rootA == None or rootB == None or rootA.val != rootB.val:
            return False

        return self.helper(rootA.left, rootB.right) and self.helper(rootA.right, rootB.left)

    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        # return self.helper(root,rootB)
        return self.recursive(root)

    def recursive(self, root: TreeNode) -> bool:
        if root == None:
            return True

        queue = []
        queue = [root.left, root.right]

        while len(queue) != 0:
            nodeA = queue.pop()
            nodeB = queue.pop()

            # Suppose we will have null, null on the left side at one point with elements on the right side of the internal node and we need to process that as well
            if nodeA == None and nodeB == None:
                continue

            if nodeA == None or nodeB == None:
                return False

            if nodeA.val != nodeB.val:
                return False

            queue.append(nodeA.left)
            queue.append(nodeB.right)

            queue.append(nodeA.right)
            queue.append(nodeB.left)

        return True
