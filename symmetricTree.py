# // Time Complexity : O(N) for both bfs dfs
# // Space Complexity : O(N) dfs and bfs
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach

## in dfs we check left of left == right of right and right of left == left of right 
## in base case we see if both are None--> then we return 
## in logic we see if either of the values is None or the values are not equal we put our flag as false
class solution:
    flag = True
    def symmetric_dfs(self, root):
        
        self.helper_dfs(self, root.left, root.right)
        return self.flag
    def helper_dfs(self, left, right):

        ## base
        if left == None and right == None:
            return 
        ##Logic

        if left == None or right == None or left.val != right.val:
            self.flag = False
            return 
        
        self.helper_dfs(self, left.left, right.right)
        self.helper_dfs(self, left.right, right.left)

## in bfs we add our elements to queue and process them level by level. we add left of left and right of right to queue 
## and also add right of left and left of right and process 2 adjacent elements at a time. and check if both are null then we continue
## if one of them is null or both their values dont match return False. Else return True
    
    def symmetric_bfs(self, root):

        queue = collections.deque()

        queue.append(root.left)
        queue.append(root.right)

        while queue:

            root_left = queue.pop()
            root_right = queue.pop()

            if root_left == None and root_right == None: continue
            if root_left == None or root_right == None: return False

            if root_left.val != root_right.val: return False

            queue.append(root_left.left)
            queue.append(root_right.right) 
            queue.append(root_left.right)
            queue.append(root_right.left)
        
        return True

            
