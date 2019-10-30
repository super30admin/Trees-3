
#time Complexity: O(n)
#Space Complexity: O(n)
#leetcode submission: successful
class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        answer=[]
        self.helper(root,sum,[],answer)
        return answer
        
    def helper(self,root,sum,path,answer):
        if not root:
            return
        if not root.left and not root.right and root.val==sum:
            path.append(root.val)
            answer.append(path)
            return
        if root.left:
            self.helper(root.left,sum-root.val,path+[root.val],answer)
        if root.right:
            self.helper(root.right,sum-root.val,path+[root.val],answer)            
        