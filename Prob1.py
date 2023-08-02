# Time complexity : O(n), number of nodes
# Space complexity : O(H), Height of the tree
# In method 2, we use BFS again, but instead of going in the order, we add things in a mirror format -> left's left, right's right,left's right and right's left. And each time check if left and right are equal.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # #Method 1 - Use BFS to Generate a list of all elements in current level and do a palindrome check using 2 pointers. 
        # q=deque()
        #if not root: return True
        # q.append(root)
        # while q:
        #     size=len(q)
        #     li=[]
        #     for i in range(size):
        #         curr=q.popleft()
        #         li.append(curr)
        #         if curr!=None:
        #             q.append(curr.left)
        #             q.append(curr.right)
        #     l=0
        #     r=len(li)-1
        #     while l<r:
        #         if not li[l] and not li[r]:
        #             l+=1
        #             r-=1
        #         elif not li[l] or not li[r]:
        #             print("here")
        #             return False
                
        #         elif li[l].val!=li[r].val: #here, you are adding TreeNode to the list, so to compare values, .val() method is needed
        #             return False         
        #         else:
        #             l+=1
        #             r-=1      
        # return True
        #Method 2 - BFS but adding it in a mirror manner -> left's left, right's right,left's right and right's left and each time check if left and right are equal.
        if not root: return True
        q=deque()
        q.append(root.left)
        q.append(root.right)

        while q:
            left=q.popleft()
            right=q.popleft()
            if not left and not right: continue
            if not left or not right: return False
            if left.val!=right.val: return False
            q.append(left.left) #mirror pattern addition
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
        return True
                    
