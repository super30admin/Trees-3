## Time Complexity : O(n*h), n is number of nodes in tree, h is height of the tree
## Space Complexity : O(h),h is the height of the tree

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        resultPath=[]
        self.helper(root,sum,[],resultPath)
        return resultPath
    def helper(self,node,remainingSum,tempStack,resultPath):
        if not node:
            return
        #add currnode to temp list
        tempStack.append(node.val)
        #check if curr node is leaf node and the sum is met, then add itto resultlist
        if remainingSum==node.val and not node.left and not node.right:
            resultPath.append(list(tempStack))
        else:
            #else we will traverse to left and right child
            self.helper(node.left,remainingSum-node.val,tempStack,resultPath)
            self.helper(node.right,remainingSum-node.val,tempStack,resultPath)
        #we need to pop once all subtrees of the node processed.
        tempStack.pop()