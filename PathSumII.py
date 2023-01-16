# Time Complexity: O(N)
# Space Complexity: O(1)
# Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.result = []
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.sol(root,0,[],targetSum)
        return self.result
    def sol(self,root,total,path,targetSum):
        if not root:
            return
        total+=root.val
        path.append(root.val)
        if not root.left and not root.right and total==targetSum:
            self.result.append(copy.copy(path))
        self.sol(root.left,total,path,targetSum)
        self.sol(root.right,total,path,targetSum)
        path.pop()
        