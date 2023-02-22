# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# All TC passed on leetocde

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        #Using BFS optimized approach
        #Time complexity - O(n) as we visit all elements of tree
        #Space complexity - O(n) - size of queue can reach max leaf nodes size i.e. n/2
        if not root:
            return True
        queue = collections.deque()
        queue.append(root.left)
        queue.append(root.right)

        while queue:
            left = queue.popleft()
            right = queue.popleft()

            if not left and not right:
                continue
            if not left or not right or left.val!=right.val:
                return False
            
            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)

        return True

    #----------------------------------OR-------------------------------------------------

        #Using BFS approach
        #Time complexity - O(n^2) as we check for each level if queue elements are palindrome
        #Space complexity - O(n) - size of queue can reach max leaf nodes size i.e. n/2
        def isPalindrome(arr):
            print(arr)
            i = 0
            j = len(arr)-1
            while i<=j:
                if not arr[i] and not arr[j]:
                    i+=1
                    j-=1
                    continue
                if not arr[i] or not arr[j]:
                    return False
                if arr[i].val!=arr[j].val:
                    return False
                i+=1
                j-=1
            return True

        if not root:
            return True
        queue = collections.deque()
        queue.append(root)
        while queue:
            if not isPalindrome(queue):
                    return False
            for i in range(len(queue)):
                cur = queue.popleft()
                if cur:
                    queue.append(cur.left)
                    queue.append(cur.right)
        return True

#----------------------------------OR-------------------------------------------------
       
        #Using DFS approach
        #Time complexity - O(n)
        #Space complexity - O(h)
        if not root:
            return True
        

        def helper(left, right):
            if not left and not right:
                return True
            
            if not left or not right or left.val!=right.val:
                return False

            l = helper(left.left, right.right)
            r = helper(left.right, right.left)

            return l and r

        return helper(root.left, root.right)