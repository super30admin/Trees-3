# Time Complexity :O(n^2)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def helper(self,path,root,arr,mySum):
        # if reached end the sum of path is the sum you want then append to sol
        if not root:
            if sum(path) == mySum:
                arr.append(path)
                return
        # check edge casses and recurse 
        elif not root.left and not root.right:
            self.helper(path+[root.val],root.left,arr,mySum)
        elif root.left and not root.right:
            self.helper(path+[root.val],root.left,arr,mySum)
        elif root.right and not root.left:
            self.helper(path+[root.val],root.right,arr,mySum)
        elif root.left and root.right:
            self.helper(path+[root.val],root.left,arr,mySum)
            self.helper(path+[root.val],root.right,arr,mySum)
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        arr = []
        self.helper([],root,arr,sum)
        return arr