# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result=[]
    #count=0
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None: return []        

        self.result=[]
        self.helper(root, targetSum, [], 0)
        return self.result

    def helper(self, root, targetSum, path, sumTillnow):
        #base-> when should it return
        if root is None: return 
        #logic
        sumTillnow+=root.val
        path.append(root.val)

        if root.left is None and root.right is None:
            if sumTillnow== targetSum:
                #appending list(path) cuz we need to store a copy of path
                #not a refernece to it
                # ds within ds always refernce, it stores only initial val
                self.result.append(list(path))
                #self.count+=1
                #print(self.count)


        self.helper(root.left, targetSum, path, sumTillnow)
        self.helper(root.right,targetSum, path, sumTillnow)
        path.pop()