package com.company;
import java.util.Scanner;

public class beibao
{
    public static void sort(Bag[] p)     //选择排序将数组中的bag按权重排序
    {
        Bag t;
        for(int i=0;i<p.length;i++)
        {
            int max=i;
            t=p[i];
            for(int j=i;j<p.length;j++)
            {
                if(t.wi<p[j].wi)
                {
                    t=p[j];
                    max=j;
                }
            }
            t=p[i];
            p[i]=p[max];
            p[max]=t;
        }
    }

    //背包问题(贪心算法)
    public static void bq(Bag[] p,int k,int w,double v)
    {
        if(p[k].weight<w)                    //物品重量小于背包剩余重量
        {
            v=v+p[k].value;                 //把物品价值加上
            System.out.println(p[k].pid+"全部装入,当前背包价值为"+v);
            w=w-p[k].weight;                //背包剩余重量
            bq(p, k+1, w, v);           //递归使用
        }
        else{
            double a=w*p[k].wi;            //当前价值
            v=v+a;                        //加入最后能装的价值
            System.out.println(p[k].pid+"装入了"+((double)w/p[k].weight)+",当前背包价值为"+v);
        }
    }

    public static void main(String args[])
    {
        System.out.println("请输入背包的容量w和物品的个数n");
        Scanner reader = new Scanner(System.in);
        int w=reader.nextInt();//背包的容量
        int n=reader.nextInt();//物品的个数
        Bag[] p=new Bag[n];
        System.out.println("请依次输入各个物品的重量w和价值v和名称s");
        int weigth;
        int value;
        String pid;
        for(int i=0;i<n;i++)               //输入数据
        {
            weigth=reader.nextInt();
            value=reader.nextInt();
            pid=reader.next();
            p[i]=new Bag(weigth,value,pid);
        }
        sort(p);     //bag按权重排序
        System.out.println("bag按权重排序后为：");
        for(int i=0;i<n;i++)     //打印排序后的权重排序
        {
            System.out.println(p[i].pid+" "+p[i].wi);
        }
        bq(p,0,w,0.0);   //运行背包问题(贪心算法)
    }
}

class Bag
{
    public int weight;//重量
    public int value;//价值
    public double wi;//权重
    public String pid;//背包名称
    /*  随机数据
    c = 10                     #书包能承受的重量
    n = 6                      #物品的数量
    w = [2, 2, 3, 1, 5, 2]     #每个物品的重量
    v = [2, 3, 1, 5, 4, 3]     #价值
    */
    public  Bag(int w,int v,String pid)
    {
        this.weight=w;
        this.value=v;
        this.pid=pid;
        this.wi=(double)value/weight;
    }
}
