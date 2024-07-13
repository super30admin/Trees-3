#I used a depth-first search (DFS) approach with a helper function to traverse the binary tree and find all paths that sum to the target value. The helper function calPathSum takes the current node, the remaining value needed to reach the target sum, and the current path as arguments. As I traverse the tree, I add each node's value to the current path. If I reach a leaf node and the remaining value minus the node's value is zero, it means the current path sums to the target, so I add a copy of this path to the result list. After exploring both left and right subtrees, I backtrack by removing the last node from the current path. This ensures that I explore all possible paths from root to leaf. The res list, which is defined outside the helper function to maintain state across recursive calls, collects all valid paths. Finally, I return the res list containing all paths that sum to the target value.

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def calPathSum(node, value, ans):
            nonlocal res
            if not node:
                return 
            ans.append(node.val)
            if not node.left and not node.right and value-node.val == 0:
                res.append(list(ans))
            # print(node.val, value, ans, res)
            calPathSum(node.left, value-node.val, ans)
            calPathSum(node.right, value-node.val, ans)
            ans.pop()
            return
        res = []
        calPathSum(root,targetSum,[])
        return res