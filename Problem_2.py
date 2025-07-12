'''
101 Symmetric Tree
https://leetcode.com/problems/symmetric-tree/description/

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

Follow up: Could you solve it both recursively and iteratively?

Let N = number of nodes, H = height of tree

Solution:
1. Recursion and stack: Traverse the left subtree using inorder traversal. For each node encountered during traversal of left subtree, push element into  a stack. Now, traverse the right subtree using inorder traversal. For each node encountered during traversal, pop element from stack and compare if the node value is equal to the popped element. If not equal, then it is not symmetric.
Space is O(N+H) because stack stores N/2 elements and there are H recursive calls which creates a stack of size H to maintain recursion states.
Time: O(N), Space: O(N + H) = O(N)

2. Recusrion w/o stack: For a given root node, recursively check if the left subtree and right subtree are symmetrical.
                    1
            2               2
        3       4       4       3

The check is performed on the two pairs of children:
a) left.left child == right.right child
b) left.right child == right.left child

Base case: If both left and right subtrees are empty, return True
           If either left or right subtrees are empty, return False
           If both left and right subtree exist but the left root val does not match with right root val, return False
https://youtu.be/m-nRJLGD96k?t=259
Time: O(N), Space: O(H) (space is due to recursion stack)


3. Iterative using queue: Perform a level order traversal. For each level, check if the node values satify the palindrome property.
https://youtu.be/m-nRJLGD96k?t=1713
Time: O(N), Space: O(D) (D = diameter of the tree)
'''
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def display(self):
        lines, *_ = self._display_aux()
        print("\n")
        for line in lines:
            print(line)

    def _display_aux(self):
        """Returns list of strings, width, height, and horizontal coordinate of the root."""
        # No child.
        if self.right is None and self.left is None:
            line = '%s' % self.val
            width = len(line)
            height = 1
            middle = width // 2
            return [line], width, height, middle

        # Only left child.
        if self.right is None:
            lines, n, p, x = self.left._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_line = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lines = [line + u * ' ' for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, n + u // 2

        # Only right child.
        if self.left is None:
            lines, n, p, x = self.right._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = s + x * '_' + (n - x) * ' '
            second_line = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lines = [u * ' ' + line for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, u // 2

        # Two children.
        left, n, p, x = self.left._display_aux()
        right, m, q, y = self.right._display_aux()
        s = '%s' % self.val
        u = len(s)
        first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s + y * '_' + (m - y) * ' '
        second_line = x * ' ' + '/' + (n - x - 1 + u + y) * ' ' + '\\' + (m - y - 1) * ' '
        if p < q:
            left += [n * ' '] * (q - p)
        elif q < p:
            right += [m * ' '] * (p - q)
        zipped_lines = zip(left, right)
        lines = [first_line, second_line] + [a + u * ' ' + b for a, b in zipped_lines]
        return lines, n + m + u, max(p, q) + 2, n + u // 2

def build_tree_level_order(values):
    N = len(values)
    if N == 0:
        return TreeNode(None)
    q = deque()
    tree = TreeNode(values[0])
    q.append(tree)
    i=0
    while i < N and q:
        node = q.popleft()
        left_index = 2*i+1
        right_index = left_index + 1
        if left_index < N and values[left_index] is not None:
            node.left = TreeNode(values[left_index])
            q.append(node.left)
        if right_index < N and values[right_index] is not None:
            node.right = TreeNode(values[right_index])
            q.append(node.right)
        i += 1
    return tree

def inorder_push(root, array):
    if not root:
        return None
    inorder_push(root.left, array)
    array.append(root.val)
    inorder_push(root.right, array)

def inorder_pop(root, array):
    if not root:
        return None
    inorder_pop(root.left, array)
    if root.val != array.pop():
        return False
    inorder_pop(root.right, array)
    return True

def is_symmetric_v1(root):
    '''T: O(N), S: O(N) '''
    if not root: # empty tree
        return True
    elif not root.left and not root.right: # no left and right subtree
        return True
    elif root.left and not root.right: # left subtree only
        return False
    elif not root.left and root.right: # right subtree only
        return False
    stack = []
    inorder_push(root.left,  stack)
    is_sym = inorder_pop(root.right, stack)
    return is_sym

def is_symmetric_v2(root):
    ''' T: O(N), S: O(H) '''
    def dfs(left, right):
        if not left and not right: # no left and right subtree
            return True
        if not left or not right:
            return False
        if left.val != right.val:
            return False
        case1 = dfs(left.left, right.right)
        case2 = dfs(left.right, right.left)
        return case1 and case2
    if not root:
        return True
    return dfs(root.left, root.right)


def is_symmetric_v3(root):
    ''' T: O(N), S: O(Diameter) '''
    if not root:
        return True
    q = deque()
    q.append(root.left)
    q.append(root.right)
    while q:
        left = q.popleft()
        right = q.popleft()
        if not left and not right: # both None
            continue
        if not left or not right: # one of them is None
            return False
        # At this point, both left and right are not None
        if left.val != right.val:
            return False
        q.append(left.left)
        q.append(right.right)
        q.append(left.right)
        q.append(right.left)
    return True

def is_symmetric(root, method=2):
    if method == 1:
        is_sym = is_symmetric_v1(root)
    elif method == 2:
        is_sym = is_symmetric_v2(root)
    elif method == 3:
        is_sym = is_symmetric_v3(root)
    return is_sym

def run_is_symmetric():
    tests = [([1,2,2,3,4,4,3], True), ([1,2,2,None,3,None,3], False), ([1,2], False), ([1,2,3], False), ([1, None, 2], False), ([1], True), ([], True)]

    for test in tests:
        root, ans = test[0], test[1]
        tree=build_tree_level_order(root)
        for method in [1,2,3]:
            is_sym = is_symmetric(tree, method)
            tree.display()
            print(f"root={root}")
            print(f"Method {method}: symmetric tree = {is_sym}")
            print(f"Pass: {ans==is_sym}")

run_is_symmetric()