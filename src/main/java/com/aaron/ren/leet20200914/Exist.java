package com.aaron.ren.leet20200914;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Exist {

    public static void main(String[] args) {

        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        exist(board,"ABCCED");

       // synchronized ();
        ReentrantLock lock=new ReentrantLock();
        Condition condition = lock.newCondition();
        CountDownLatch countDownLatch=new CountDownLatch(1);
        Semaphore semaphore=new Semaphore(2);




    }

    public  static  boolean exist(char[][] board, String word) {

        //利用回溯的方法 要点在于 从每个节点进行遍历 查看是不是符合要求
        boolean[][] used =new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                   StringBuffer path=new StringBuffer();
                    if(dfs(board,word,i,j,used,path)){     //dfs 进行回溯
                        return  true;
                    }
                }
            }
        }
        return  false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, boolean[][] used,  StringBuffer path) {

        System.out.println(path.toString());
        if(path.toString().contains(word)){
            return true;
        }else if(word.contains(path)){
            //进行回溯 四个方向回溯
            //
            //这里进行剪子操作
            if (i < 0 || i>=board.length||j<0||j>=board[0].length)
            {
                return false;
            }

            if(used[i][j]==false){
                path.append(board[i][j]);
                used[i][j]=true;
                //仔细理解 递归的妙处
                if (dfs(board, word, i+1, j, used, path)){
                    return true;
                }
                if (dfs(board, word, i-1, j, used, path)){
                    return true;
                }
                if (dfs(board, word, i, j+1, used, path)){
                    return true;
                }
                if (dfs(board, word, i, j-1, used, path)){
                    return true;
                }
                path.deleteCharAt(path.length()-1);
                used[i][j]=false;

            }

        }
            return false;


    }
}
