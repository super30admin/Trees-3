#Time Complexity: O(n)
#Space Complexity: O(m)
#LeetCode: Yes

class Node:
    def __init__(self, data):
        self.val = data
        self.left = None
        self.right = None


class Solution:
    def isSymmetric(self, root):
        if root == None:
            return True
        return self.helper(root.left, root.right)

    
    def helper(self, left, right):
        if left == None and right == None:
            return True
        if left != None and right == None:
            return False
        if left == None and right != None:
            return False
        if left.val != right.val:
            return False

        case1 = self.helper(left.left, right.right)
        case2 = self.helper(left.right, right.left)
        return case1 and case2

if __name__ == "__main__":
    root = Node(1)
    root.left = Node(2)
    root.right = Node(2)
    root.left.left = Node(3)
    root.left.right = Node(4)
    root.right.left = Node(4)
    root.right.right = Node(3)

    obj = Solution()
    print(obj.isSymmetric(root))