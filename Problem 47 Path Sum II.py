# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(n^2)
# Space Complexity: O(n)
# Logic: follow normal preorder iteration & store current list too in the stack. check the number if equal to target
# append it into the ouput else keep on going.

class Node:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self, root):
        self.root = Node(root)

    def pathSum(self, root, targetSum):
        self.output = []
        number = 0
        stack = []
        cur_list = []
        while stack or root:
            while root:
                number = number + root.val
                cur_list.append(root.val)
                stack.append((root, number, cur_list.copy()))
                root = root.left
            root, number, cur_list = stack.pop()
            if not root.left and not root.right and (number == targetSum):
                self.output.append(cur_list.copy())
            root = root.right
        return self.output


tree = Solution(5)
tree.root.left = Node(4)
tree.root.right = Node(8)
tree.root.left.left = Node(11)
tree.root.left.right = Node(None)
tree.root.right.left = Node(13)
tree.root.right.right = Node(4)
tree.root.left.left.left = Node(7)
tree.root.left.left.right = Node(2)
print(tree.pathSum(tree.root, 22))
