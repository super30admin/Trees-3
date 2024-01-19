# Solution

# // Time Complexity : Recursive/DFS and iterative takes O(N) since we need to go over all the nodes
# // Space Complexity : Recursive/DFS will by default save each call in stack so takes O(HEIGHT) but here HEIGHT 
#                       can be N at the max
#                       Iterative, we need to create a queue to save each node in the same order as symmetric check is needed
#                       this queue size can go upto size of number of elements so it will be O(N) here as well
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# There are two approaches
# Approach1 is to perform DFS using recursion and compare the left.left with right.right, also compare right.left with left.right
# As we continue the DFS, for each node control reaches to the leftmost and rightmost node first, then compare them and then returns 
# to the current node. Traversing will be in order. The left and right of ROOT gets checked last if we have done post order check
# checked first of we use pre order check and checked middle if we used in order check.

# Approach2 is to perform BFS using iterative approach, we can go level by level and add them into queue. Start with adding root
# twice to queue, then pop them and check if they are matching and then put the (left.right and right.left) to queue and 
# also (left.left and right.right) to queue which will be popped again in the next iteration. Iteration continues till the queue is not empty. 

from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def isSymmetric(root):
# S30/Leetcode Editorial Video solution - Iterative(BFS)    
    nodeQueue = deque()
    nodeQueue.append(root)
    nodeQueue.append(root)
    while len(nodeQueue) != 0:
        left = nodeQueue.popleft()
        right = nodeQueue.popleft()

        if left == None and right == None:
            continue

        if left == None or right == None or left.val != right.val:
            return False

        nodeQueue.append(left.left)
        nodeQueue.append(right.right)
        nodeQueue.append(left.right)
        nodeQueue.append(right.left)
    
    return True

    # S30 Solution, recursive(DFS)
    # def dfs(left,right):
    #     if left == None and right == None:
    #         return True
        
    #     if left == None or right == None or left.val != right.val:
    #         return False
        
    #     if not dfs(left.left,right.right):
    #         return False
    #     if not dfs(left.right,right.left):
    #         return False
        
    #     return True

    # if not dfs(root.left,root.right):
    #     return False
    # return True

def buildLinkedList(index,n):
    if index >= n:
        return None
    return TreeNode(ar[index],buildLinkedList(index*2 + 1,n),buildLinkedList(index*2 + 2,n))

if __name__ == "__main__":
    ar = [2,3,3,4,5,None,4]
    n = len(ar)
    root = TreeNode(ar[0],buildLinkedList(1,n),buildLinkedList(2,n))
    print(isSymmetric(root))