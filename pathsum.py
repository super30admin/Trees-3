# time complexity:O(N)
# no doubts
# leetcode: accepted


# you create two list - one list to track the path
# and you create one more list which consistes of the result of these paths

# everytime you go down from one node to another node , you append the root value to the path list which keeps track f
# your path. And you going down till you get a leaf node. you add that path to your result if the sum matches the leaf value

# if the sum and leaf node doesnt match, you return and while retuning you remove the elements from the path
# so that you don't get the worng path


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        result = list()
        path = list()
        self.traverse(root, sum, result, path)
        return result

    def traverse(self, root, sum, result, path):
        if (root == None):
            return
        path.append(root.val)

        if (root.left == None and root.right == None and sum == root.val):
            result.append(list(path))
            # result.append(path)  WHY IF I APPEND IN THIS WAY, IT DOESN'T WORK.  GIVES WRONG O/P
            return

        if (root.left != None):
            self.traverse(root.left, sum - root.val, result, path)
            path.pop()

        if (root.right != None):
            self.traverse(root.right, sum - root.val, result, path)
            path.pop()





