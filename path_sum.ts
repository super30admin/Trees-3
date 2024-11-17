import { Tree } from "istanbul-lib-report";
import { number } from "yargs";

class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

// N = Number of nodes in the tree
// H = Height of the tree
// TC: O(N) SC: O(H)
function path_sum(root: TreeNode | null, target: number): number[][] {
  // Global Variable
  let result: number[][] = [];

  // Recursive Function
  function helper(
    root: TreeNode | null,
    target: number,
    currentSum: number,
    path: number[]
  ) {
    // Base condition
    if (root == null) return;

    currentSum += root.val;
    let new_path = [...path];
    new_path.push(root.val);

    if (root.left == null && root.right == null && currentSum == target) {
      // let deepCopy: number[] = [...path];
      result.push(new_path);
    } else {
      helper(root.left, target, currentSum, new_path);
      helper(root.right, target, currentSum, new_path);
    }
  }

  // Main Code
  helper(root, target, 0, []);
  return result;
}

// N = Number of nodes in the tree
// H = Height of the tree
// TC: ? SC: ?  TODO: Figure Out
function path_sum_with_backtracking(
  root: TreeNode | null,
  target: number
): number[][] {
  let result: number[][] = [];
  function helper_with_backtracking(
    root: TreeNode | null,
    target: number,
    currentSum: number,
    path: number[]
  ) {
    // Base condition
    if (root == null) return;

    currentSum += root.val;
    path.push(root.val);

    if (root.left == null && root.right == null && currentSum == target) {
      result.push([...path]);
    } else {
      helper_with_backtracking(root.left, target, currentSum, path);
      helper_with_backtracking(root.right, target, currentSum, path);
    }

    path.pop();
  }
  helper_with_backtracking(root, target, 0, []);
  return result;
}

describe("Path Sum", () => {
  it("Happy Path", () => {
    let target = 22;
    let root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);

    expect(path_sum(root, target)).toStrictEqual([
      [5, 4, 11, 2],
      [5, 8, 4, 5],
    ]);
    expect(path_sum_with_backtracking(root, target)).toStrictEqual([
      [5, 4, 11, 2],
      [5, 8, 4, 5],
    ]);
  });
});
