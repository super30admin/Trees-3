# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity : o(n)
#Space Complexity : o(h) + o(n*h)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        self.result = []
        self.target = targetSum
        self.helper(root, [], 0)
        return self.result

    def helper(self, root: Optional[TreeNode], list1: list, currSum: int) -> None:

        if root == None:
            return

        newSum = currSum + root.val
        newList = list1 + [root.val]

        if root.left == None and root.right == None:
            if newSum == self.target:
                self.result.append(newList)
                return

        self.helper(root.left, newList, newSum)
        self.helper(root.right, newList, newSum)

        newList.pop()




## pop way
#Time Complexity : o(n)
#Space Complexity : o(h) + o(h)
class Solution:
    # Definition for a binary tree node.
    # class TreeNode:
    #     def __init__(self, val=0, left=None, right=None):
    #         self.val = val
    #         self.left = left
    #         self.right = right


    class Solution:
        def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

            self.result = []
            self.target = targetSum
            self.helper(root, [], 0)
            return self.result

        def helper(self, root: Optional[TreeNode], list1: list, currSum: int) -> None:

            if root == None:
                return

            newSum = currSum + root.val
            list1.append(root.val)

            if root.left == None and root.right == None:
                if newSum == self.target:
                    self.result.append([i for i in list1])

            self.helper(root.left, list1, newSum)
            self.helper(root.right, list1, newSum)

            list1.pop()