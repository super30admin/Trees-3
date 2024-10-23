"""
Approach1: take a global boolean variable whose value will be updated if the tree has targetSum. When a recursive call
is made to the next node, the sum till current node is passed as parameter. Before making the recursive call, the
total that needs to be passed to the next recursive call is calculated first. Total here is a local variable, each
recursive call has its own value of local variable.

Edge case: total == targetSum is checked for the leaf nodes only meaning which do not have left and right child.
For the approach1 code (helper_approach1), the base case is "if not node" total == targetSum is may not be
checked in base case since the base case is by the left and right child of leaf node which are None. So this check
is done after adding the current node value to total and before making recursive call.

Approach2: in the previous approach, even if the path is found, recursive calls are made. How to optimize this?
We can use conditional recursion, where we check if the global boolean variable has become True or not, meaning targetSum
is found. Note: if this condition is checked before calling recursion on left or right child like in approach2, then the
function call is not made at all. If it is checked in the base case, then call is made but returned from the base case.

Note: If once targetSum is found, and after that statement return is written, it will return to the place from where
it was called, meaning the line below (or the tree below) the return statement will not be executed.
And the rest of the recursion continues.

Approach3: boolean based recursion. where left child call, right child call, base case, another check based on question,
the whole recursive function have to return the answer. CONDITIONAL RECURSION can be applied here as well.

Always check if: the processing done during the recursive call could be done in, in order pre oder, post order way.

Time complexity: O(n), number of nodes SC: O(h) height of tree
"""
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def helper_approach3(self, node, target, total, ans):
        # base case
        if not node:
            print(total)
            return

            # recursive case
        total += node.val
        if not node.left and not node.right:
            if target == total:
                ans[0] = True
                return ans[0]

        left = self.helper_approach3(node.left, target, total, ans)

        right = self.helper_approach3(node.right, target, total, ans)

        return left or right



    def helper_approach2(self, node, target, total, ans):
        # base case
        if not node:
            print(total)
            return

            # recursive case
        total += node.val
        if not node.left and not node.right:
            if target == total:
                ans[0] = True
        if not ans[0]:
            self.helper_approach2(node.left, target, total, ans)
        if not ans[0]:
            self.helper_approach2(node.right, target, total, ans)

    def helper_approach1(self, node, target, total, ans):
        # base case
        if not node:
            return

            # recursive case
        total += node.val
        if not node.left and not node.right:
            if target == total:
                ans[0] = True

        self.helper_approach1(node.left, target, total, ans)

        self.helper_approach1(node.right, target, total, ans)

    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        ans = [False]
        if not root:
            return False

        self.helper_approach1(root, targetSum, 0, ans)
        return ans[0]


