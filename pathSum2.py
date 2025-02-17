# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x: int) -> None:
#         self.val = x
#         self.left = None
#         self.right = None

# Time Complexity: O(N ^2)
# Space Complexity: O(N)
 
class Solution:

    def recurseTree(
        self,
        node: TreeNode,
        remainingSum: int,
        pathNodes: List[int],
        pathsList: List[List[int]],
    ) -> None:

        if not node:
            return


        pathNodes.append(node.val)

  
        if remainingSum == node.val and not node.left and not node.right:
            pathsList.append(list(pathNodes))
        else:

            self.recurseTree(
                node.left, remainingSum - node.val, pathNodes, pathsList
            )
            self.recurseTree(
                node.right, remainingSum - node.val, pathNodes, pathsList
            )



        pathNodes.pop()

    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        pathsList = []
        self.recurseTree(root, sum, [], pathsList)
        return pathsList