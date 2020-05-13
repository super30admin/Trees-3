# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Problem 1: Path Sum II
#Time Complexity: O(n^2) create copy of elements each time
#Space Complexity: O(n^2) copy of elements each time
#Did it work on leetcode:
'''
Brute force: test each path from the top, save in an array, if it adds to sum append it to array
'''

'''
Main idea:
Similar to previous problem, we the present array in the call stack , add
the next value, when we reach the leaf, we sum all the elements in array and check it it's valid.
We could just keep the sum, and if it's a valid branch go up until the root and save it, although it would save
space in the callstack, seems too complicated for not much added.
'''
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res=[]
        #careful, we have to pass in copies and not the array itself
        #or else any change in any recursion will affect it
        def helper(root,elements=[],s=0):
            #edge case
            if not root:
                return

            elements.append(root.val)
            s+=root.val
            if not root.left and not root.right:
                if s==sum:
                    res.append(elements)
                return
            helper(root.left,elements[:],s)
            helper(root.right,elements[:],s)
        helper(root)
        return res

#Problem 1: Path Sum II
#Time Complexity: O(n)
#Space Complexity: O(n)
#Did it work on leetcode:  yes


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res=[]
        #careful, we have to pass in copies and not the array itself
        #or else any change in any recursion will affect it
        def helper(root,elements=[],s=0):
            #edge case
            if not root:
                return

            elements.append(root.val)
            s+=root.val
            if not root.left and not root.right:
                if s==sum:
                    res.append(elements)
                return
            helper(root.left,elements[:],s)
            helper(root.right,elements[:],s)
        helper(root)
        return res


#Problem 1: Path Sum II
#Time Complexity: O(n)
#Space Complexity: O(n)
#Did it work on leetcode:  yes

'''
Main idea:
Instead of passing a copy, we can just pop an element if both
iterations have been terminated. In other words, the order of how the elements are appended to list is the same
as how they are in the call stack. So when we pop an element from the call stack
if we pop it from the list, the next last element of list is exactly the next
element in the call stack, exactly what we need since we want our list to keep
track of what had been visited until that last element in the stack.
To visualize it, first time we arrived at a certain element, or when we return
to this element after poping from the stack, the state of the stack is the same.
Also the list of elements first time we visited that element, or when we pop
and go back to this element, it should be exactly the same. What's in List is
what's in my call stack at that point.
'''
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res=[]
        elements=[]
        s=0
        #careful, we have to pass in copies and not the array itself
        #or else any change in any recursion will affect it
        def helper(root,elements,s):
            #edge case
            if not root:
                return
            elements.append(root.val)
            s+=root.val
            if not root.left and not root.right:
                if s==sum:
                    #careful we need to pass in a copy for the result
                    #or else it will be changed when we change elements
                    res.append(elements[:])
            helper(root.left,elements,s)
            helper(root.right,elements,s)
            elements.pop()
        helper(root,elements,s)
        return res



#Problem 2: Symmetric Tree
#Time Complexity: O(n)
#Space Complexity: O(h) call stack
#Did it work on leetcode:  yes

'''
Brute force
Reconstruct the tree by going through each path,but right becomes left.
Compare the tree with the original.
'''
'''
Main idea:
We start from the two subtrees (t1,t2) left and right from the top, we check if they have the same value,
if so we check if t1.left has the same value as t2.right, and t1.right with t2.left. If so , we check
continue doing so until the end. If we encounter a problem we return False, if everything was passed,
we return true. basically, given two trees at the same level, when we grow something to the left,
the other one should grow something to the right. To visualize it , see what one single branch and it's symmetric counterpart
is doing it, if I start from two heads. If the branch goes left, on my other head it should go right, then the path of the first branch should always be opposite to the path of the other branch all the way down. It's the same as saying, compare
the next move of the node right with the node left of the other tree. Always compare with the opposite. That's what
we're doing in the recursion

'''
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True

        def helper(t1,t2):
            #base case
            if not t1 and not t2:
                return True
            if not t1 or not t2:
                return False
            #it's possible that one branch doesn't
            #grow but the other one does

            #we always track the corresponding symmetric branch (the opposite movement)
            #until the branches are terminated or we have something not equal
            return (t1.val==t2.val) and helper(t1.left,t2.right) and helper(t1.right,t2.left)
        return helper(root.left,root.right)
