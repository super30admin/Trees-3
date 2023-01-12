/*
    approach 1: inorder traversal with recursion
    - We will save local state at each node
        - instead of saving a running sum at each node, we will subtract target from root.val
        - So target will be maintained at each node ( updated target )
        - We will also keep track of a list thats maintaining running path ( using go slices )*
            - slices are pass by value
            - slices have len and cap as properties
            - cap = total size avail
            - len = current occupied size
            - slices also have a ptr to 1 underlying array and they use len and cap to make growing and shrinking decisions
            - this is important because since we wont allocate a specific size slice we want the slice to grow and shrink as needed
            - the side effect of this is using in recursion, is that at some node len will be 3 while cap will be 4 ( meaning the underlying array still has size )
            - remember the underlying arr is a ref.
            - slice is pass by value ( copy of top level meta info like len, cap, but arr ref is STILL THE SAME )
            - but when the slice says that it still has capacity , we go down a branch and come back and to the same node that said the underlying arr still has capacity
            - but! it does not. The local state is out of date because when we down a branch , it added an element and made len == cap
            - but when the recursion popped the top of the stack, in that local state for the same slice is something else ( because slices are pass by value )
            - so we have 2 different states while the underlying array may be full..
            - The only workaround I have found so far is - when saving the result, ENSURE its being copied into a new slice and then save the new slice or else 
                - the underlying array ( ref ) gets changed and then your result will change too....
            - in python, its all pass by ref, so we can easily backtrack and remove 1 element and all nodes have the same truth vs in Golang the truth once we go back to a prev node is a lie! so careful! ( I learned this after spending an entire day of troubleshooting .......)
        - once we run into a target == 0 and current node is a leaf node
        - Then we will add the running path to a resulting list
            - which means we will also maintain a reference to a slice of result array
        
        - time: o(n^2) - we visit every single node and when we do find an answer, we have to copy 1 slice to another to avoid the side effects above
        - space:
            - o(h) for recursion stack
            - and when we do find an answer, we allocate another o(n) slice to copy current paths slice into
            - o(hn)
            Not sure if this is correct ^
        
        
        approach 2: inorder but iterative
        - When we pop the top of the stack,
        - We must reset the "local recursion" state to match the top of the stack
        - this also had the same slice problem ( so had to copy )
        - time: o(n^2)
        - space: o(h for stack) * if at the current node we find an answer we allocate o(n) to save paths - o(hn)

*/
func pathSum(root *TreeNode, targetSum int) [][]int {
    out := [][]int{}
    var dfs func(r *TreeNode, currSum int, path []int)
    dfs = func(r *TreeNode, currSum int, path []int) {
        // base
        if r == nil {return}
        // logic
        
        // action
        currSum += r.Val
        path = append(path, r.Val)

        // recurse
        dfs(r.Left, currSum, path)
        
        if r.Left == nil && r.Right == nil && currSum == targetSum {
            newL := make([]int, len(path))
            copy(newL, path)
            out = append(out, newL)
            return
        }
        
        
        dfs(r.Right, currSum, path)
        // backtrack
        path = path[:len(path)-1]
    }
    dfs(root, 0, nil)
    return out
}
