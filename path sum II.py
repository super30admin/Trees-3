class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        self.pathSumRec(root, res, [], targetSum)
        return res

    def pathSumRec(self, node: Optional[TreeNode], res: List[List[int]], candidate: List[int], targetSum: int):
        if node is None:
            return
        if node.right is None and node.left is None:  # leaf
            if targetSum - node.val == 0:
                candidate.append(node.val)
                res.append(candidate)
            return

        candidate.append(node.val)
        copy = candidate[:]

        self.pathSumRec(node.left, res, candidate,  targetSum - node.val)
        self.pathSumRec(node.right, res, copy, targetSum - node.val)

# Time complexity: O(n*log(n))
# Space complexity: O(2^n * log(n))
