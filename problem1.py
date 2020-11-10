"""
Time: O(2^heightOfTree)
Space: O(n) on recursive stack
Leet: Accepted
Problems: None

"""


class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        res = []

        def helper(root,value,target,path):
            if root:
                if not root.left and not root.right:
                    pathsum = value + root.val
                    if pathsum == target:
                        path += [root.val]
                        res.append(path)
                helper(root.left, value+root.val,target,path+[root.val])
                helper(root.right, value+root.val,target,path+[root.val])


        helper(root,0,sum,[])
        return res
