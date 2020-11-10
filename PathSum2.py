"""
The approach here is to start from root and deduct all the intermediate node values in every path and if
the leaf node equals to the remaining sum value it means we have a valid path.
"""
def pathSum(self, root, sum):
        result = []
        self.Findpath(root,sum,[],result)
        return result
    
    def Findpath(self,root,sum,output,result):
        if not root:
            return None
        
        if not root.left and not root.right and sum == root.val:
            output.append(root.val)
            result.append(output)
            return
        
        sum -= root.val
        output.append(root.val)
        
        self.Findpath(root.left,sum,output[:],result)
        self.Findpath(root.right,sum,output[:],result)