'''
113 Path Sum II
https://leetcode.com/problems/path-sum-ii/description/

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: []

Example 3:
Input: root = [1,2], targetSum = 0
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

Solution:
1. Brute Force: Traverse through each node while maintaining a running sum of all node values encountered until the current node and the path (list). On reaching the leaf node, check if the running sum == target sum. If yes, copy the path to the result. The disadvantage of this method is that we maintain a
new path (list) at each node by copying the path values to the new path. Thus,
time spent is for N nodes during traversal and copying the path values to a new list at each node. The list size for non-skewed trees is about H (height of tree nodes). Thus, for non-skewed tress, time is O(NH). For skewed trees, H = N, hence the time is O(N^2). Likewise, space is determined by the recursion stack and the list size
T: O(NH), S: O(NH)

2. Recursion + Backtracking:
Similar to the brute force logic. The only difference is that we don't create a new path for each node. We use the same path list across all nodes but we backtrack by removing the last visited node value so that the path until the root of the visited node is accurate till the root node.
Time: Visiting N nodes, C = no. of leaves at which we reach target sum, and at such nodes we copy about H nodes from the path to the final result
Space: N = size of path we pass during recusion, H = recursion stack
https://youtu.be/TC5DPQkFb7g?t=1847
T: O(N + CH) = O(N), S: O(N + H) = O(N)
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

def path_sum_v1(root, target_sum):
    ''' T: O(NH), S: O(NH)
         Visiting N nodes and at each node we are copying about H nodes from the path
    '''
    def dfs(root, curr_sum, target_sum, path):
        if not root:
            return None

        path.append(root.val)
        curr_sum += root.val

        # only when we reach child node, we check if the curr_sum is equal to target_sum
        if not root.left and not root.right:
            if curr_sum == target_sum:
                result.append(path)

        dfs(root.left, curr_sum, target_sum, path.copy())
        dfs(root.right, curr_sum, target_sum, path.copy())

    if not root:
        return []
    result = []
    dfs(root, 0, target_sum, [])
    return result

def path_sum_v2(root, target_sum):
    ''' T: O(N + CH) = O(N), S: O(N + H) = O(N)
         Time: Visiting N nodes, C = no. of leaves at which we reach target sum, and at such nodes we copying about H nodes from the path to the final result
         Space: N = size of path we pass during recusion, H = recursion stack
    '''
    def dfs(root, curr_sum, target_sum, path):
        if not root:
            return None

        path.append(root.val)
        curr_sum += root.val

        # only when we reach child node, we check if the curr_sum is equal to target_sum
        if not root.left and not root.right:
            if curr_sum == target_sum:
                result.append(path.copy())
                #print(f"result = {result}")

        dfs(root.left, curr_sum, target_sum, path)
        dfs(root.right, curr_sum, target_sum, path)
        path.pop() # pop the current root.val

    if not root:
        return []
    result = []
    path = []
    dfs(root, 0, target_sum, path)
    return result

def path_sum(tree, target_sum, method=2):
    if method == 1: # brute-force (recursion)
        path_sum_v1(tree, target_sum)
    elif method == 2: # recursion + backtrack
        path_sum_v2(tree, target_sum)
    else:
        print(f"Invalid method {method}")

def run_path_sum():
    tests = [([5,4,8,11,None,13,4,7,2,None,None,5,1], 22, [[5,4,11,2],[5,8,4,5]])]
    for test in tests:
        root, target_sum, ans = test[0], test[1], test[2]
        tree=build_tree_level_order(root)
        target_sum=22
        paths = path_sum_v2(tree, target_sum)
        tree.display()
        print(f"\nroot = {root}")
        print(f"Target sum = {target_sum}")
        print(f"Paths = {paths}")
        print(f"Pass: {ans == paths}")

run_path_sum()