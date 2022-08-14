# Time complexity: O(n*H) or technically O(n^2) as H can be max N 
# Space Complexity: O(n*H) or O(n^2)  H is the height of the BST
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# # Definition for a binary tree node.
# # class TreeNode:
# #     def __init__(self, val=0, left=None, right=None):
# #         self.val = val
# #         self.left = left
# #         self.right = right
# class Solution:
#     def __init__(self):
#         self.ans = collections.deque()
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
#         def helper(root,curr,path, targetSum):
#             if not root:
#                 return
            
#             curr_path = collections.deque() # MUST CREATE A NEW LOCAL LIST FOR PATH
#             # DATA STRUCTURE IN A DATA STRUCTURE IS A POINTER
#             # IF we give path instead of takin an new curr_path, all elements keep on adding to path and we will get all nodes added to it. That is why we use a local curr_path to counter this
            
#             # Add path to curr_path first
#             curr_path += path # This takes O(H) time by itself # H can be max N in worst case
            
#             curr = curr + root.val
#             curr_path.append(root.val) # Add root.val to curr_path
            
#             if not root.left and not root.right:
#                 #Leaf node
#                 if curr == targetSum:
#                     self.ans.append(curr_path)
            
#             helper(root.left,curr,curr_path,targetSum)
           
#             helper(root.right,curr,curr_path,targetSum)

################## BACTRACKING SOLN ###############
########### BACTRACKING : ACTION -> RECURSE -> BACKTRACK

# Time complexity: O(n) # the temp list can be ignored. Technically its O(n*h) if temp comes up n times but practically the number of times we have to create a new temp that is no.of paths selected for the answer is negligible 
# Space Complexity: O(n)  H is the height of the BST

class Solution:
    def __init__(self):
        self.ans = collections.deque()
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        def helper(root,curr,targetSum):
            if not root:
                return
            
            # ACTION
            curr = curr + root.val
            path.append(root.val) # Add root.val to path
            
            if not root.left and not root.right:
                #Leaf node
                if curr == targetSum:
                    temp = collections.deque() # WE NEED temp as path will keep changing as its the same reference being passed and changed everywhere. We use temp which creates a new adrress and this path won't keep changing
                    temp += path
                    self.ans.append(temp)
            
            # RECURSE
            helper(root.left,curr,targetSum)
            helper(root.right,curr,targetSum)
            
            #### BACTRACK
            path.pop()+
            
            
            

        path = collections.deque()
        helper(root,0,targetSum)
        return self.ans

