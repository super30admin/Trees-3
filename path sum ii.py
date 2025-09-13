# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Solution 1: Void function based recursion, no backtracking.
    - curr_path_sum : paramater of recursion, as it's a primitive data structure and it
                      preserves the state when recursion function returns at line of 
                      function call by doing one-to-one mapping
    - curr_path : Data-structure in a data-structure, reference. This could be made global 
                  too but not advisable as it gets hard for someone else reviewing the code
                  Since, this is parsed as reference in recursive calls, same list is used
                  meaning, same list gets updated with operations on list.
                  Hence, we create deepcopies of this list at each node. 
    - Time COmplexity: O(N) + O(N^2) = O(N^2)
                       - O(N) for visiting each node. 
                       - O(N^2) for creating a deepcopy of list at each node (copying the elements)
    - Space complexity: O(h) + O(N^2) = O(N^2)
                       - O(h) h is the height of tree, for recursion stack,
                         worst case, h = N and best case, h = logN
                       - O(N^2) for having a list of N elements (worst) at each node.  
'''
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.paths = []
        dummy_path = []
        self.helper(root,targetSum,0,dummy_path) # curr_node, target, curr_path_sum, dummy_path_list

        return self.paths
    
    def helper(self,curr_node, target, curr_path_sum, curr_path):
        # base
        if curr_node == None:
            return 
        
        # logic
        curr_path_sum = curr_path_sum + curr_node.val
        this_node_path = deepcopy(curr_path) # we make new list at each node. 
        this_node_path.append(curr_node.val)
        
        if curr_node.left == None and curr_node.right == None: #leaf node
            if curr_path_sum == target: # target-path
                self.paths.append(this_node_path)
        
        # left traverse
        self.helper(curr_node.left, target, curr_path_sum, this_node_path)

        # right traverse
        self.helper(curr_node.right, target, curr_path_sum, this_node_path)


'''
Solution 2: Void function based recursion, with backtracking.
    - curr_path_sum : paramater of recursion, as it's a primitive data structure and it
                      preserves the state when recursion function returns at line of 
                      function call by doing one-to-one mapping
    - curr_path : Data-structure in a data-structure, reference. This could be made global 
                  too but not advisable as it gets hard for someone else reviewing the code
                  Since, this is parsed as reference in recursive calls, same list is used
                  meaning, same list gets updated with operations on list.
                  Hence, we do backtracking for each action that is done.  
    - Time COmplexity: O(N)
                       - O(N) for visiting each node. 
                       (we assume that only few paths would be present. Hence creating a deepcopy
                       of paths when we match the targetSum, would be negligible. or in other words
                       O(kN), where k is small)
    - Space complexity: O(h) 
                       - O(h) h is the height of tree, for recursion stack,
                         worst case, h = N and best case, h = logN  
'''
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.paths = []
        dummy_path = []
        self.helper(root,targetSum,0,dummy_path) # curr_node, target, curr_path_sum, dummy_path_list

        return self.paths
    
    def helper(self,curr_node, target, curr_path_sum, curr_path):
        # base
        if curr_node == None:
            return 
        
        # logic
        curr_path_sum = curr_path_sum + curr_node.val
        # action 
        curr_path.append(curr_node.val)
        
        if curr_node.left == None and curr_node.right == None: #leaf node
            if curr_path_sum == target: # target-path
                self.paths.append(deepcopy(curr_path))
        
        # left traverse
        self.helper(curr_node.left, target, curr_path_sum, curr_path)
    
        # right traverse
        self.helper(curr_node.right, target, curr_path_sum, curr_path)

        # when both sub-trees of curr node is visited, we backtrack
        curr_path.pop()
