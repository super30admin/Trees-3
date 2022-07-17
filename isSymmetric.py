"""
Runtime Complexity:
O(n) - because we traverse all the nodes from the root and append it to our queue to compare and check whether the left subtree and right subtree are symmetric.
Space Complexity:
O(n) - our queue will have 'n' nodes. Although when a pop happens we don't append all the nodes to the queue but still queue would have value greater than 'h'. Therefore the overall space complexity is O(n).
Yes, the code worked on leetcode.
Idea behind the algorithm - BFS
"""
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
    
        if not root:
            return True
        q = []
        q.append(root.left)
        q.append(root.right)
        
        while q:
            left = q.pop()
            right = q.pop()
            if not left and not right:
                continue
            if not left or not right or left.val!=right.val:
                return False
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
        return True
        
       