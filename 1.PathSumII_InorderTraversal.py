# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    """
    Time Complexity: 0(n)
    Space Complexity : 0(h) -- h is height of tree
    Approach: Traversal with backtracking
    """

    def __init__(self):
        self.currSum = 0
        self.resultList = []
    
    def __traversal(self, node: Optional[TreeNode], currSum: int, targetSum:int, path:List[int]) -> None:
        
        # base-case
        if node == None:
            return 
        
        # logic-case
        
        # 1. action
        # add node.val to the path
        path.append(node.val)
        
        # update currSum
        currSum += node.val
        
        # 2. recurse
        # chk for sum
        if currSum == targetSum and (node.left == None and node.right == None):
            # create copy of path
            cpyPath = path.copy()
            # add to the path
            self.resultList.append(cpyPath)
        
        else:
            # go-left
            self.__traversal(node.left, currSum, targetSum, path)

            # go-right
            self.__traversal(node.right, currSum, targetSum, path)
        
        
        # 3. backtracking -- reverting your action
        # remove the last addition from the list
        path.pop()
        # update the currSum
        currSum -= node.val

        return


    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.__traversal(root, 0, targetSum, [])
        return self.resultList