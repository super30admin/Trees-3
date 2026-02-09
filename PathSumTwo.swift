//
//  RootToLeafSumPathTwo.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/27/26.
//

class RootToLeafSumPathTwo {
    
    init() {
        
    }
    /*
     In worst case, h will be n. left skewed tree. O(n2)
     2.Space complexity - O(n *h) - everytime, creating a new list while deep copying.
     
     Backtrack - To be back to the previous state. Whatever we did before the recursion call, we have to remove it. To backtrack the action that we took before recursion. time complexity - O(n), space compelxity - O(h)
     */
    //using global result variable
    
    var result = [[Int]]()
    func pathSum(_ root: TreeNode?, _ targetSum: Int) -> [[Int]] {
        var path: [Int] = []
        getTargetSumPaths(root, targetSum: targetSum, path: path, currentSum: 0)
        return result
    }
    
    func getTargetSumPaths(_ root: TreeNode?, targetSum: Int, path: [Int], currentSum: Int) {

       //base
       guard let root = root else {
            return
       }

       //logic
       let currSum  = currentSum + root.val

       //action
       var p = path
       p.append(root.val)
       if (root.left == nil && root.right == nil) {
            if (currSum == targetSum) {
                result.append(p)
            }
            return
       }

       //recurse
       getTargetSumPaths(root.left, targetSum: targetSum, path: p, currentSum: currSum)
       getTargetSumPaths(root.right, targetSum: targetSum, path: p, currentSum: currSum)

        //backtrack - not needed because list is value type in Swift, not reference type
    }

    //MARK: without using global result variable
    /*
     time complexityt - O(n * h), in worst case scenario - n can become n - O(n^2)
     copying all elements from path to p is taking O(h) time complexity. worst case O(n)
     space compelxity -> O(n * h), at all nodes, we are copying elements from one list to another, we are keeping auxilliary list.. It's time inefficient.
     */
    func getTargetSumPathsTwo(_ root: TreeNode?, targetSum: Int, path: [Int], currentSum: Int) -> [[Int]] {
        //base
        guard let root = root else {
            return [[Int]]()
        }

        //logic
        let currSum = currentSum + root.val
        var resultArray = [[Int]]()
        //action
        //deep copy of path. append the new element
        var p = path
        p.append(root.val)
        if (root.left == nil && root.right == nil) {
            if (currSum == targetSum) {
                resultArray.append(p)
                return resultArray
            }
        }
        
        //recurse
        let resultFromLeft = getTargetSumPathsTwo(root.left, targetSum: targetSum, path: p, currentSum: currSum)
        let resultFromRight = getTargetSumPathsTwo(root.right, targetSum: targetSum, path: p, currentSum: currSum)
        resultArray.append(contentsOf: resultFromLeft)
        resultArray.append(contentsOf: resultFromRight)
        return resultArray
    }
    
    /*
     For better time and space complexity, use refernce type  and use backtracking. Remove the last element which was added to get back to the previous state.
     When we got the path, then copy the path in the result by changing the refernce (to not mutate it again when changing something else).
     when backtracking - removal from the end is O(1)
     time compelxity - O(n). just traversing over all the nodes. Not creating deep copies.
     space complexity -> O(h). because the auxilliary list can't go beyond height of the tree. Recursion call stack will also be O(h)
     */
    
    //backtrack
    func getTargetSumPathsUsingBacktracking(_ root: TreeNode?, targetSum: Int, path: inout [Int], currentSum: Int) {
        var path = path
        //base
        guard let root = root else {
            return
        }

        //logic
        let currSum = currentSum + root.val
        print("path \(path)")
        //action
        path.append(root.val)
        print("after path \(path)")
        if (root.left == nil && root.right == nil) {
            if (currSum == targetSum) {
                let p = path
                result.append(path)
            }
            return
        }

        //recurse
        getTargetSumPathsUsingBacktracking(root.left, targetSum: targetSum, path: &path, currentSum: currSum)
        getTargetSumPathsUsingBacktracking(root.right, targetSum: targetSum, path: &path, currentSum: currSum)

        //backtrack
        print("while backtracking \(path)")
        path.removeLast()
        print("after backtracking \(path)")
    }

}
