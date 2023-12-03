# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res=[]
    def helper(self,root,cur_sum,cur_path,targetSum):
        
        if root==None:
            return

        cur_path=cur_path+[root.val]
        cur_sum=cur_sum+root.val

        if root.left==None and root.right==None and cur_sum==targetSum:
            self.res.append(cur_path)

        self.helper(root.left,cur_sum,cur_path,targetSum)
        self.helper(root.right,cur_sum,cur_path,targetSum)


        # if root.left==None and root.right==None and sum1==targetSum:
        #     self.res.append(lis.copy())
        #     print(sum1)
        #     print(targetSum)
        #     print("hello "+str(self.res))
        #     return
        
        # if root.left==None and root.right==None:
        #     return

        # if root.left:
        #     temp=[]
        #     temp=(lis.copy())
        #     temp.append(root.left.val)
        #     self.helper(root.left,sum1+root.left.val,temp,targetSum)
        # if root.right:
        #     temp=[]
        #     temp=(lis)
        #     temp.append(root.right.val)
        #     self.helper(root.right,sum1+root.right.val,temp,targetSum)
        

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        self.helper(root,0,[],targetSum)
        # if root is not None:
        #     self.helper(root,root.val,[root.val],targetSum)
        # else:
        #     return []
        print(self.res)
        return self.res
        