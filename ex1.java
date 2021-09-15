class Solution {
    List<List<Integer>> list= new ArrayList<List<Integer>>();
    List<Integer> l = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        int arr[] =new int[1250];
        pathSumList(root, sum, arr, 0);
        return list;
    }
    
    public void pathSumList(TreeNode root, int sum, int[] arr,int i){
         if(root == null) return;
        sum= sum-root.val;
        arr[i++]=root.val;
        if(root.left == null && root.right ==null && sum==0){
            for(int k=0;k<i;k++){
                l.add(arr[k]);
            }
            list.add(l);
            l=new ArrayList<Integer>();
        }
        else{
             pathSumList(root.left,sum,arr,i);
            pathSumList(root.right,sum,arr,i);
        }
    }
}