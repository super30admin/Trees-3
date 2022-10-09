#Time Complexity:O(n^2) where n is number of nodes at specific height of the tree and
#time required to copy elements from path to new arraylist for each node
#Space Complexity : O(n^2) creation of new arraylist for each node to  copy elements from path
#did your code run on leetcode: yes

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
        
            if(root.left == None and root.right == None):
                if(currSum == targetSum):
                    result.append(path)
            #Here every time we are copying path into new list due to which we are able to maintain state of the path at every node 
            #eventhough all element are getting added in the path 
            self.helper(root.left,targetSum,path.copy(),currSum)
            self.helper(root.right,targetSum,path.copy(),currSum)
