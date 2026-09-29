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
from binary_tree import *

def path_sum_v1(root, target_sum):
    ''' T: O(NH), S: O(NH)
         Visiting N nodes and at each node we are copying about H nodes from the path
    '''
    def dfs(root, curr_sum, path):
        # nonlocal target_sum, result

        if not root:
            return

        # ---- Logic ----
        curr_sum += root.val # Not an action,
        # since it does not need to be undone (backtracked)

        # Action
        path.append(root.val)
        if not root.left and not root.right:
            # child node
            if curr_sum == target_sum:
                result.append(path)

        # Recursion
        dfs(root.left, curr_sum, path.copy())
        dfs(root.right, curr_sum, path.copy())


    if not root:
        return []
    path = []
    result = []
    dfs(root, 0, path)
    return result


def path_sum_v2(root, target_sum):
    ''' T: O(N + CH) = O(N), S: O(N + H) = O(N)
        Time: Visiting N nodes, C = no. of leaves at which we reach target sum, and at such nodes we copying about H nodes from the path to the final result
        Space: N = size of path we pass during recusion, H = recursion stack
    '''
    def dfs(root, curr_sum, path):
        # nonlocal target_sum, result

        if not root:
            return

        # ---- Logic ----
        curr_sum += root.val # Not an action,
        # since it does not need to be undone (backtracked)

        # Action
        path.append(root.val)
        if not root.left and not root.right:
            # child node
            if curr_sum == target_sum:
                result.append(path.copy())

        # Recursion
        dfs(root.left, curr_sum, path)
        dfs(root.right, curr_sum, path)

        # Backtrack
        path.pop()

    if not root:
        return []
    path = []
    result = []
    dfs(root, 0, path)
    return result


def path_sum(tree, target_sum, method=2):
    path = []
    if method == 1: # brute-force (recursion)
        path = path_sum_v1(tree, target_sum)
    elif method == 2: # recursion + backtrack
        path = path_sum_v2(tree, target_sum)
    else:
        print(f"Invalid method {method}")
    return path

def run_tests():
    tests = [([5,4,8,11,None,13,4,7,2,None,None,5,1], 22, [[5,4,11,2],[5,8,4,5]])]
    for test in tests:
        root, target_sum, ans = test[0], test[1], test[2]
        tree=build_tree_level_order(root)
        tree.display() if tree else None
        res1 = path_sum(tree, target_sum, 1)
        res2 = path_sum(tree, target_sum, 2)
        print(f"\nroot = {root}")
        print(f"Target sum = {target_sum}")
        print(f"1. Paths = {res1} (Brute Force)")
        print(f"2. Paths = {res2} (Recursion and Backtracking)")
        passed = (ans == res1 == res2)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")

    print(f"\nDONE")

run_tests()