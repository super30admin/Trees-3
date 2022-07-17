# Time complexity: O(n)
# Space complexity: O(n)
# Approach: BFS-queue
# put roots left and right in to queue
# run a loop until queue is empty
# check left and right nodes by popping them if they are same or not
# put lefts left, right's right, left's right and right's left into the queue

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        from queue import Queue
        q = Queue()
        q.put(root.left)
        q.put(root.right)
        while not q.empty():
            left = q.get()
            right = q.get()
            if left == None and right == None:
                continue
            if left == None or right == None or left.val != right.val:
                return False
            q.put(left.left)
            q.put(right.right)
            q.put(left.right)
            q.put(right.left)
        return True