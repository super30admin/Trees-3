# Time Complexity :O(N)
# Space Complexity :O(LogN)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:
    # result=[]
    # def list_append(self, val):
    #     l=[]
    #     l.append(val)
    #     return l

    def helper(self, root, tar,c_sum, path, result):
        #base
        if(root==None):
            return
        if(root.left==None and root.right==None):
            c_sum+=root.val
            print(c_sum, root.val)
            if(c_sum==tar):
                path.append(root.val)
                result.append(path)
            return result
        #logic
        c_sum+=root.val        
        self.helper(root.left, tar, c_sum, path+[root.val],result)
        self.helper(root.right, tar, c_sum,path+[root.val], result)
        if(len(path)):
            path.pop()
        return result


    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        # self.result=[]
        return self.helper(root, targetSum,0, [],[])
        print(self.result)
        return self.result