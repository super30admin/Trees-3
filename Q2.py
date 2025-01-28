########### Symmetric Tree

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : was initially confused about the conditions to check symmetric


# Perform bfs on the tree while popping two elements and keep checking if the elements satisfy the symmetric conditions.

def is_symmetric(root):
        if not root:
            return True

        q = [root.left,root.right]
        while q:
            left = q.pop(0)
            right = q.pop(0)
            if not left and not right:
                continue
            if not left or not right:
                return False
            if left and right:
                q.append(left.left)
                q.append(right.right)
                q.append(left.right)
                q.append(right.left)
            if left.val != right.val:
                return False
        return True
