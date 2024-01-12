#Problem: Symmetric Tree
#time: O(N)
#Space: O(N)
#approach: BFS
# Used BFS to traverse the tree and keep track of the current path and current sum. If the current node is a leaf node and the current sum is equal to the target sum, we will append the current path to the result. If not, we will traverse the left and right subtree and backtrack the current path.

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root.left and not root.right:
            return True
        queueLeft = deque()
        queueRight = deque()

        queueLeft.appendleft(root.left)
        queueRight.appendleft(root.right)

        while queueLeft and queueRight:
            nodeLeft, nodeRight = queueLeft.pop(), queueRight.pop()
            if not nodeLeft and not nodeRight:
                continue
            # both node must exist
            # if exists thet must have the same value
            if not nodeLeft or not nodeRight or nodeLeft.val != nodeRight.val:
                return False

            queueLeft.appendleft(nodeLeft.left)
            queueLeft.appendleft(nodeLeft.right)

            queueRight.appendleft(nodeRight.right)
            queueRight.appendleft(nodeRight.left)
        return not (queueLeft or queueRight)
