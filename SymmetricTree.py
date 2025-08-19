# Time Complexity : It is O(n) since we are iterating with all nodes.
# Space Complexity : It is O(n) considering all the leaves of the nodes can be in the queue.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

import queue
class Solution:
    

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        if(root.left == None and root.right == None ):
            return True
        if(root.left == None or root.right == None ):
            return False

        return self.validateMirror(root)

    
    def validateMirror(self, root: Optional[TreeNode]) -> bool:
        NodeQueue = queue.Queue(maxsize=0)
        NodeQueue.put(root.left)
        NodeQueue.put(root.right)

        while(not (NodeQueue.empty())):
            leftNode = NodeQueue.get()
            rightNode = NodeQueue.get()
            print(leftNode)
            print(rightNode)

            if(leftNode == None and rightNode == None ):
                continue                
            if leftNode.val != rightNode.val:
                return False        
            if(leftNode.left == None and rightNode.right != None ):
                return False
            if(rightNode.left == None and leftNode.right != None ):
                return False
            if(leftNode.left != None and rightNode.right == None ):
                return False
            if(rightNode.left != None and leftNode.right == None ):
                return False
    
            NodeQueue.put(leftNode.left)
            NodeQueue.put(rightNode.right)
            NodeQueue.put(leftNode.right)
            NodeQueue.put(rightNode.left)

        return True
        