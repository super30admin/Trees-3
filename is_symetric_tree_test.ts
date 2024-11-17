import { stat } from "graceful-fs";
import { Tree } from "istanbul-lib-report";
import { help } from "yargs";

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
// TC: O(N) SC: O(N)
function isSymmetric(root: TreeNode | null): boolean {
  let lhs: number[] = [];
  let rhs: number[] = [];

  pre_order_traversal(root?.left, lhs);
  post_order_traversal(root?.right, rhs);

  if (lhs.length != rhs.length) return false;

  for (let index = 0; index < lhs.length; index++) {
    if (lhs[index] != rhs[index]) return false;
  }

  return true;
}

function pre_order_traversal(
  root: TreeNode | null | undefined,
  visits: number[]
) {
  if (root == null) {
    visits.push(-1);
    return;
  }

  visits.push(root.val);
  pre_order_traversal(root.left, visits);
  pre_order_traversal(root.right, visits);
}

function post_order_traversal(
  root: TreeNode | null | undefined,
  visits: number[]
) {
  if (root == null) {
    visits.push(-1);
    return;
  }

  visits.push(root.val);
  post_order_traversal(root.right, visits);
  post_order_traversal(root.left, visits);
}

describe("Is Symmetric", () => {
  it("Happy Path", () => {
    let root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    expect(isSymmetric(root)).toStrictEqual(true);
  });

  it("Negative Path", () => {
    let target = 22;
    let root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(4);
    expect(isSymmetric(root)).toStrictEqual(false);
  });
});
