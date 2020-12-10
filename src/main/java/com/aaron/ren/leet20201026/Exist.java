package com.aaron.ren.leet20201026;

public class Exist {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        exist(board,"ABCCED");
    }

    //单词搜索
    public  static boolean exist(char[][] board, String word) {

        boolean [][] useed=new boolean[board.length][board[0].length];
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    StringBuffer path=new StringBuffer();
                    if(dfs(board,i,j,useed,path,word)){
                        return true;
                    };

                }
            }

        }

         return false;

    }

    private static boolean dfs(char[][] board, int i, int j, boolean[][] useed, StringBuffer path,String word) {


        if(path.toString().contains(word)){
            return true;
        }else if(word.contains(path)){
             //考虑进行回溯了
            if(i<0||j<0||i>=board.length||j>=board[0].length){
                return false;
            }

            if(useed[i][j]==false){
                path.append(board[i][j]);
                useed[i][j]=true;
                dfs(board, i-1, j, useed, path, word);
                dfs(board, i+1, j, useed, path, word);
                dfs(board, i, j-1, useed, path, word);
                dfs(board, i, j+1, useed, path, word);

                useed[i][j]=false;
                path.deleteCharAt(path.length()-1);

            }

        }
            return false;


    }
}
