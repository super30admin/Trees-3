#Time Complexity O(N2)
#Space Complexity O(N)
class Solution:
    
    def recurseTree(self, node, remainingSum, nodes, result_list):
        
        if node == None:
            return 
        
        nodes.append(node.val)
        if remainingSum == node.val and not node.left and not node.right:
            result_list.append(list(nodes))
        else:    
            self.recurseTree(node.left, remainingSum - node.val, nodes, result_list)
            self.recurseTree(node.right, remainingSum - node.val, nodes, result_list)
        nodes.pop()    
    
    def pathSum(self, root: TreeNode, sum_data: int) -> List[List[int]]:
        result_list = list()
        self.recurseTree(root, sum_data, list(), result_list)
        return result_list
