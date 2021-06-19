"""
Approach-1: recursively check for the symmetric child nodes of each sibling...
TC: O(n)
SC: O(n)
"""

def isSymmetric(self, root: TreeNode) -> bool:
    if not root:
        return 1

    return self.helper(root.left, root.right)


def helper(self, left, right):
    if not left and not right:
        return 1
    if left and right and left.val == right.val:
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
    return 0

"""
Approach-2: Iteratively check for the symmetric children nodes of each sibling. Since we process nodes in BFS manner or 
level order traversal, we use a queue here.

TC: O(n)
SC: O(n)
"""

def isSymmetric(self, root: TreeNode) -> bool:
    if not root:
        True

    queue = deque()
    queue.append((root, root))
    while queue:
        pair = queue.popleft()
        node_left = pair[0]
        node_right = pair[1]
        if not node_left and not node_right: continue
        if not node_left or not node_right: return False
        if node_left.val != node_right.val: return False

        queue.append((node_left.left, node_right.right))
        queue.append((node_left.right, node_right.left))
    return True