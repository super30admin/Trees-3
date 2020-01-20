from typing import List
from create_tree_node import stringToTreeNode, TreeNode


class Solution:

    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        """
            // Time Complexity : O(n)
                    'n' is the number of nodes
            // Space Complexity : O(h)
                    'h' is the height of the tree
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english:
                - Idea is similar to recursive solution
                - Trying to memic recursion using POST ORDER TRAVERSAL
        """
        results = []
        if not root:
            return results

        cur_list = []
        cur_sum = 0

        # Post order
        # LRD Preorder
        stack = []
        last_visited_node = None
        while root or stack:
            if root:
                # going to left child
                cur_sum += root.val
                cur_list.append(root.val)
                stack.append(root)
                root = root.left
            else:
                peek_node = stack[-1]
                # going to right child
                if peek_node.right and last_visited_node != peek_node.right:
                    root = peek_node.right
                else:
                    # coming to root
                    cur = stack.pop()
                    if cur_sum == sum and (cur.left is None and cur.right is None):
                        results.append(list(cur_list))
                    cur_sum -= cur.val
                    cur_list.pop()
                    last_visited_node = cur
        return results

    def pathSum_recursive(self, root: TreeNode, sum: int) -> List[List[int]]:
        """
        // Time Complexity : O(n)
                'n' is the number of nodes
        // Space Complexity : O(h)
                'h' is the height of the tree
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        // Three line explanation of solution in plain english:
            - Recursively calculate sum of each path.
            - At each level when we are done with the left and right sub trees we
              pop that element.
            - Check if we are at leaf and the sum is equal to target sum.
              A leaf is a node with no children (both left and right).
        """
        results = []
        if not root:
            return results
        self._helper(root, results, [], 0, sum)
        return results

    def _helper(self, root: TreeNode, result: List[List], cur_list: List, cur_sum: int, target_sum: int):
        # base
        if root is None:
            return

        # logic
        cur_sum += root.val
        cur_list.append(root.val)
        if cur_sum == target_sum and (root.left is None and root.right is None):
            result.append(list(cur_list))

        self._helper(root.left, result, cur_list, cur_sum, target_sum)
        self._helper(root.right, result, cur_list, cur_sum, target_sum)

        # backtracking
        # when are at leaf helper function is still called recursively.
        # then the leaf is popped.
        # For other nodes as well, when both the subtrees are done,
        # the root is popped.
        cur_list.pop()


if __name__ == '__main__':
    h = Solution()
    root = stringToTreeNode([5, 4, 8, 11, 'null', 13, 4, 7, 2, 'null', 'null', 5, 1])
    print(h.pathSum(root, 22))
    print(h.pathSum_recursive(root, 22))
    root = stringToTreeNode([-2, 'null', -3])
    print(h.pathSum(root, -5))
    print(h.pathSum_recursive(root, -5))
    root = stringToTreeNode([1, 2])
    print(h.pathSum(root, 1))
    print(h.pathSum_recursive(root, 1))
    root = stringToTreeNode([4, 3])
    print(h.pathSum(root, 1))
    print(h.pathSum_recursive(root, 1))
