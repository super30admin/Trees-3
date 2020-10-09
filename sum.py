// Time Complexity : O(N*N)
// Space Complexity :O(N*N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        paths = []
        
        def helper(node, total, path):
            if node:
                if not node.left and not node.right:
                    if total + node.val == sum:
                        paths.append(path+[node.val])
                    return
                helper(node.left, total + node.val, path + [node.val])
                helper(node.right, total + node.val, path + [node.val])
                
        helper(root, 0, [])
        return paths