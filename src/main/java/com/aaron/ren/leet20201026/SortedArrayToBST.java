package com.aaron.ren.leet20201026;

public class SortedArrayToBST {
    public int findCircleNum1(int[][] M) {
        int peopleCount = M.length;
        int[] visited = new int[peopleCount]; // 开辟访问

        int count = 0;
        for (int i = 0; i < peopleCount; i++){
            if (visited[i] == 0){ // 当前同学没被访问过
                dfs(M, visited, i, peopleCount);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] M, int[] visited, int i, int peopleCount){
        for (int j = 0; j < peopleCount; j++){
            if (M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(M, visited, j, peopleCount);
            }
        }
    }
    public static void main(String[] args) {

    }

    public static  TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);

    }
    public static  TreeNode sortedArrayToBST(int [] nums,int left,int right){
        if(left>right) {
            return null;                                        //边界条件，注意是left>right
        }
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(nums,left,mid-1);        //递归向左探索，范围变成left~mid-1;
        root.right=sortedArrayToBST(nums,mid+1,right);
        return root;
    }


    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
