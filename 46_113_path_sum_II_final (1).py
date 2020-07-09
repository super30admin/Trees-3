# Pallavi Sapale

# to understand backtracking
# deverything fixed
# yet to try with iterative approach and DFS , yet to ask where to return in backtrack solution exactly
# similar to 129. root to leaf


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:

        # Method 2 : Backtrack solution : ( Stack under the hood ) complexities same as iterative
        # Time complexity : O(N^2) == O(N/2 * h) , time needed for creating copy, every copy is a linear copy, n copies at n nodes
        # Space complexity : O(h) auxilary space, one list can hold max O(h) elements, O(n) for skewed tree
        # more space efficient than normal recursion because we are not making copies
        # result is not considered in space

        '''
        - recursion had different copy of pointers, in backtrack same poiner ( reference ) passed hence space is less
        - but copies are created at every node just like recusrion, so time is same
        -
        Problem :
        - Dont keep pushing same paths, push a copy of path else we get empty list
        - Above problem occurs because we recurse and then remove all elements , and return empty list, coz we backtrack

        '''
        # Leetcode : Acceps the submission

        '''
        self.result = [] # stores paths in lists of lists
        target = 0
        target = sum
        self.result = self.backtrack(root,0,[],sum)
        print('final',self.result) # prints empty list if we keep pushing same paths
        return self.result #no need to return here



    def backtrack(self, root,curr_sum, path,sum):

        #base case:
        if root == None: return # should be return 0, but 


        # logic

        # before checking for leaf , lag in stack is fixed
        curr_sum += root.val # root = 5, curr_Sum = 5, root = 4, curr_sum = 9
        path.append(root.val)

        # ACTION
        # check leaf
        if root.left == None and root.right == None:
            if sum == curr_sum: # made target a global variable
                print(sum)
                self.result.append(path.copy())# we add a copy of path now to result because, we ar using same pointers at every node
                print(self.result)

        # RECURSE  
        # no copy  needed now, we are using same array list
        # because of backtrack, path has the samea shape when we pop the element from the stack
        # if we return self.backtrack, it is not backtrack it is recursion

        self.backtrack(root.left,curr_sum,path,sum) # done in slightly different manner than leet problem : 129
        self.backtrack(root.right,curr_sum,path,sum)

        # uncomment this to see the results
        #self.check_sum(root.left,curr_sum,path,sum) # done in slightly different manner than leet problem : 129
        #self.check_sum(root.right,curr_sum,path,sum) # creates new copy everytime called

        # BACKTRACK
        path.pop() # removes last element in the path list, O(1)
        return self.result


        '''

        # Method 1 : Recursive solution : ( Stack over the hood )
        # Time complexity : O(n^2) - every copy is a linear copy, n copies at n nodes
        # Space complexity : O( n^2 ), every node uses O(n) space, n nodes use n spaces
        # the space complexity does not consist of stack space, it is O(h), but anyways O(n^2) is greater than O(h)

        '''
        - do not make a single pointer to path to store everything
        - make different pointer for every path at every node
        - 
        Problem :
        - remember it is root to leaf node

        '''
        # Leetcode : It runs,
        # but initally dint work in leet : ran but did not accept the submission, glitch in leet

        # uncomment this for recursive function

        self.result = []  # stores paths in lists of lists

        self.target = sum
        newpath = []
        self.check_sum(root, 0, [], sum)
        return self.result  # no need to return here

    def check_sum(self, root, curr_sum, path, sum):

        # base case:
        if root == None: return  # should be return 0, but

        # logic

        # before checking for leaf , lag in stack is fixed
        curr_sum += root.val  # root = 5, curr_Sum = 5, root = 4, curr_sum = 9
        path.append(root.val)
        # check leaf
        if root.left == None and root.right == None:
            if sum == curr_sum:  # made target a global variable
                print(self.target)
                newpath = path
                self.result.append(
                    path)  # we are adding the same path ( pointer to path again and again), not creating copy just passing the reference to the result
                path = []
                print(self.result)

        self.check_sum(root.left, curr_sum, path.copy(),
                       sum)  # done in slightly different manner than leet problem : 129
        self.check_sum(root.right, curr_sum, path.copy(), sum)

        # uncomment this to see the results
        # self.check_sum(root.left,curr_sum,path,sum) # done in slightly different manner than leet problem : 129
        # self.check_sum(root.right,curr_sum,path,sum)

        return self.result

























