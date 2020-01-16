package com.company;
public class bag01 {
    static int totalweight= 150;                     //背包容量
    static int N= 5;                                 //物品的数量
    static int values[] = {60, 20, 10, 60, 100};     //价值
    static int weights[] = {20, 30, 50, 60, 80};     //物品重量

    public static void main(String[] args) {
        System.out.println("递归调用结果为：");
        System.out.println(bagProblem(N-1,totalweight));
        System.out.println("非递归调用结果为：");
        bag2();
    }

    public static int bagProblem(int i, int j) {       //递归实现，处理到第i件物品，剩余的空间为j
        int r = 0;
        if(i==-1){    //i==-1说明背包被遍历完了
            return 0;
        }
        if (j>=weights[i]){              //如果剩余空间大于所放的物品
            int r1 = bagProblem(i-1,j-weights[i]) + values[i];    //放第i件
            int r2 = bagProblem(i-1,j);    //不放第i件
            r = Math.max(r1,r2);
        }
        return r;
    }

    public static void  bag2(){             //非递归
        int f[] = new int[totalweight+1];
        for (int f1:f){
            f1 = 0;
        }
        for (int i=0;i<N;i++){        //从第一个
            int w = weights[i];
            int v = values[i];
            for (int j= totalweight;j>=w;j--){
                f[j] = Math.max(f[j],f[j-w]+v);      //f[j]不放，[j_w]+v 放
            }
        }
        System.out.println(f[totalweight]);
    }
}

