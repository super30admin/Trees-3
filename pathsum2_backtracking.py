#time complexity : O(n)
#Space Complexity : O(h) where h is height of tree
#did your code run on leetcode : yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    global result
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        global result
        result = []

        if root == None : return
        self.helper(root,targetSum,[],0)
        return result
        
        
    def helper(self, root: Optional[TreeNode], targetSum: int,path:List[int],currSum : int)->None:
            
            if root == None: return
            global result
            path.append(root.val)
            currSum += root.val
            
            #copy of path when currSum == targetSum is stored in the result due to which even if the all the nodes in path get deleted we will get the state at of path when targetSum is achieved
            if(root.left == None and root.right == None):
                if(currSum == targetSum):
                    result.append(path.copy())#copy of path stored in result

            self.helper(root.left,targetSum,path,currSum)
            self.helper(root.right,targetSum,path,currSum)
            del path[len(path)-1] #backtracking

