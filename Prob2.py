# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], target: int) -> List[List[int]]:
        res=[]

        # Intial version using same reference path list -> error

        # def helper(root,target,cursum,path):
        #     #base
        #     if not root: return

        #     #logic
        #     cursum+=root.val
        #     path.add(root.val)
        #     if not root.left and not root.right:
        #         if cursum==target:
        #             res.append(path)

        #     helper(root.left,target,cursum,path)
        #     helper(root.right,target,cursum,path)

        # helper(root,target,0,[])
        # return res

        #Fix 1. using a deep copy at every node - O(n*h) SC and TC

        # def helper(root,target,cursum,path):
        #     #base
        #     if not root: return

        #     #logic
        #     cursum+=root.val
        #     li=copy.deepcopy(path)
        #     li.append(root.val)
        #     if not root.left and not root.right:
        #         if cursum==target:
        #             res.append(li)

        #     helper(root.left,target,cursum,li)
        #     helper(root.right,target,cursum,li)

        # helper(root,target,0,[])
        # return res

        #Fix 2. Use backtracking + deepcopy - O(n) SC and TC
        def helper(root,target,cursum,path):
            #base
            if not root: return

            #logic 
            #action
            cursum+=root.val
            path.append(root.val)
            if not root.left and not root.right:
                if cursum==target:
                    li=copy.deepcopy(path) #deepcopy the current path and to res list when target reached
                    res.append(li)
            #recursion
            helper(root.left,target,cursum,path)
            helper(root.right,target,cursum,path)

            #backtrack
            path.pop() #backtracking - after done with current node i,e done with it's left and right recursive calls, remove it from path list

        helper(root,target,0,[])
        return res