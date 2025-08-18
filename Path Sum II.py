# Time Complexity :O(N)
# Space Complexity :O(H^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
# Your code here along with comments explaining your approach: The code finds all root-to-leaf paths where the sum of node values equals targetSum. It uses a deque as a stack to perform DFS, storing the current node, remaining target, and the path so far. When a leaf node with the required sum is reached, the path is added to the result list paths, which is returned at the end.

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        q, paths = deque([(root, targetSum, [])]), []

        while q:
            root, target, path = q.pop()
            if not (root.left or root.right) and root.val == target:
                paths.append(path + [root.val])

            else:
                if root.left:
                    q.appendleft((root.left, target - root.val, path + [root.val])) 
                if root.right:
                    q.appendleft((root.right, target - root.val, path + [root.val])) 
        return paths