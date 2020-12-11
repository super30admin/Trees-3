/*
class Solution:
    def pathSum(self, root: TreeNode, summ: int) -> List[List[int]]:
        self.result = []
        if root is None:
            return self.result
        
        self.helper(root, summ, 0, [])
        return self.result
        
        
    def helper(self, root, summ, curSum, path):
        if root is None:
            return
        
        path.append(root.val)
        curSum += root.val
        
        if root.left is None and root.right is None:
            if curSum == summ:
                self.result.append(path)
        
        self.helper(root.left, summ, curSum, []+path)
        self.helper(root.right, summ, curSum, []+path)

class Solution:
def pathSum(self, root: TreeNode, summ: int) -> List[List[int]]:
    self.result = []
    if root is None:
        return self.result
    
    self.helper(root, summ, 0, [])
    return self.result
    
    
def helper(self, root, summ, curSum, path):
    if root is None:
        return
    
    path.append(root.val)
    curSum += root.val
    
    if root.left is None and root.right is None:
        if curSum == summ:
            self.result.append([]+path)
            
    
    self.helper(root.left, summ, curSum, path)
    self.helper(root.right, summ, curSum, path)
    path.pop()

*/

/*
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        helper(root, sum, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int sum, int curSum, List<Integer> path){
        if (root == null){
            return;
        }
        
        curSum = curSum + root.val;
        path.add(root.val);
        
        if (root.left == null && root.right == null){
            if (curSum == sum){
                result.add(path);
            }
        }
        
        helper(root.left, sum, curSum, new ArrayList<>(path)); // we cant pass path here as arraylist is mutable ie it will pass by 
                                                            //reference so it will be like maintaining global variable and any changes 
                                                            //made will be visible in all states of recursion
        helper(root.right, sum, curSum, new ArrayList<>(path)); // we can optimize this step as creating new arraylist every recursive call is expensive
    }
}
*/

// Time Complexity : O(n)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I maintained a current sum and every time when a path hits required sum
// I created a new arraylist and appended the path to it

// made some optimization with the code that now the space complexity will be O(n^2) only when every path will have the required sum

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        helper(root, sum, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int sum, int curSum, List<Integer> path){
        if (root == null){
            return;
        }
        
        curSum = curSum + root.val;
        path.add(root.val);
        
        if (root.left == null && root.right == null){
            if (curSum == sum){
                result.add(new ArrayList(path)); // only O(n^2) when every path contains the sum otherwise it would be better than earlier sol
            }
        }
        
        helper(root.left, sum, curSum, path);
        helper(root.right, sum, curSum, path);
        path.remove(path.size()-1);
    }
}