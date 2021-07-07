# Definition for a binary tree node.
#tried modifying sum function
#ran in leetcode

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :rtype: int
        """
        lst = []
        lst_path = []
        self.helper_func(root,sum,lst,lst_path)
        return lst

    def helper_func(self, root, sum, lst,lst_path):

        # base_case
        if root == None:
            return
        lst_path.append(root.val)
        if root.left == None and root.right == None and sum == root.val: #as we keep decrementing sum
            lst.append(list(lst_path))
            return
        elif root.left == None and root.right == None and sum != root.val:
            #path.pop()
            return
        #left = self.helper_func(root.left, 10 * value + root.val,sum, b)
        self.helper_func(root.left, sum - root.val, lst,lst_path )
        if root.left != None:
            lst_path.pop()
        self.helper_func(root.right, sum - root.val, lst,lst_path )
        if root.right != None:
            lst_path.pop()



    class Solution2:
        def pathSum(self, root, sum):
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
                return

            if (root.left != None):
                self.traverse(root.left, sum - root.val, result, path)
                path.pop()

            if (root.right != None):
                self.traverse(root.right, sum - root.val, result, path)
                path.pop()



