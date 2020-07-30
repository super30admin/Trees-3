class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        def helper(node,remainingsum,List,Final_list):
            #None nodes
            if not node:
                return
            #List
            List.append(node.val)
            #condition for Final_list
            if remainingsum==node.val and not node.left and not node.right:
                    Final_list.append(list(List))
            else:
                #recursive approach
                helper(node.left,remainingsum-node.val,List,Final_list)
                helper(node.right,remainingsum-node.val,List,Final_list)
            #removing the last added element from list
            List.pop()
   
        Final_list=[]
        helper(root,sum,[],Final_list)
        return Final_list
#Time-Complexity:O(N^2) considering copying elements to List
#Space-Complexity: O(N)