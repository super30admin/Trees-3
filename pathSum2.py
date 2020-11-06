# To find all the paths travserse the tree recursively and add to global variable when sum equals to target sum.
#Time complexity: O(h)
#Space Complexity: O(num_of_arrays)

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.paths = list()
    def pathSum(self, root: TreeNode, sum: int):
        if root is None:
            return
        self.helper(root,[],sum)
        return self.paths
        
    def helper(self,root,currArr,targetSum):
        if root is None:
            return 
        currArr.append(root.val)
        
        if root.left is None and root.right is None and sum(currArr) == targetSum:
            self.paths.append(list(currArr))
        else:
            self.helper(root.left,currArr,targetSum)
            self.helper(root.right,currArr,targetSum)
        currArr.pop()

n1 = TreeNode(5)
n2 = TreeNode(4)
n3 = TreeNode(8)
n4 = TreeNode(11)
n5 = TreeNode(13)
n6 = TreeNode(4)
n7 = TreeNode(7)
n8 = TreeNode(2)
n9 = TreeNode(5)
n10 = TreeNode(1)
n1.left = n2
n1.right = n3
n2.left = n4
n3.left = n5
n3.right = n6
n4.left = n7
n4.right = n8
n6.left = n9
n6.right = n10
s = Solution()
s = s.pathSum(n1,22)
print(s)