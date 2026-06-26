# Problem1 (https://leetcode.com/problems/path-sum-ii/)
# Time Complexity: O(n), we visit every node once; building each saved path costs O(h) and there can be up to O(n) such paths in the worst case (skewed tree)
# Space Complexity: O(h), h is the tree height; that's how deep the recursion stack and the shared "path" list go (output space for result not counted)

# Approach:
# We walk down the tree from root to leaf using recursion, keeping ONE shared list called "path" that holds the values of the current branch we're standing on.
# At every node we do 3 things: add it to the running sum add it to "path"and check if we've hit a leaf with the matching sum (if so, save a COPY of the path).
# Then we go explore the left child completely, then the right child completely.
# Once both children are fully done, we "pop" (remove) the current node from "path" before going back to the parent (this is called backtracking.)
# It undoes our own change so the path is clean and correct for whichever branch gets explored next.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []                          # empty box to collect all winning paths
        self.helper(root, targetSum, 0, [])       # start walk: sum so far = 0, path so far = empty
        return self.result                        # give back everything we found

    def helper(self, root, targetSum, currSum, path):
        if root is None:                          # no node here (empty spot, ran off the tree)
            return                                # nothing to do, go back to caller

        currSum = root.val + currSum              # add this node's value to the running sum
        path.append(root.val)                     # add this node's value to the shared path

        if root.left is None and root.right is None:   # this node has no children, it's a leaf
            if currSum == targetSum:                    # check if the sum matches target
                self.result.append(list(path))           # save a COPY of path (not the same list!)

        self.helper(root.left, targetSum, currSum, path)    # fully explore the left side first
        self.helper(root.right, targetSum, currSum, path)   # then fully explore the right side
        path.pop()                                # done with this node, remove it before going back(undoes the append from above — keeps path clean for the next branch the parent explores)