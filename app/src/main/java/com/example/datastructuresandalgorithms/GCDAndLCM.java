package com.example.datastructuresandalgorithms;

import android.util.Log;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jinwh on 16-12-21.
 *
 * 最大公约数
 * Greatest common divisor
 * 最小公倍数
 * Least common multiple
 */

public class GCDAndLCM {
    static public String TAG = "GCDAndLCM";
    static public void getGCDAndLCM(int[] array){
        int gcd = getArrayGCD(array);
        int lcm = getArrayLCM(array);
        Log.d(TAG,"gcd is " + gcd + "   lcm is " + lcm);
    }

    /**
     * 最大公约数问题
    1.辗转相除法：
    用f(x,y)表示x和y的最大公约数，取k=x/y,b=x%y,则x=ky+b，
    如果一个数能够同时整除x和y，则必须同时整除b和y，反之也成立。
    即x和y的公约数与b和y的公约数是相同的，最大公约数也是相同的。
    则f(x,y)=f(y,y%x)(y>0),把原问题化为求两更小数的最大公约数，
    直到其中一个数为0，剩下的另外一个数就是两者的最大公约数。

    2.迭代相减法：
    如果一个数能够同时整除x和y（假设x比较大），则必须同时整除y
    和x-y，反之亦然。也就是说x和y的公约数与x-y和y的公约数相同。
    其最大公约数也是相同的，则f(x,y)=f(x-y,y)(x>y).把原问题化为
    求两更小数的最大公约数，直到其中一个数为0.

    3.迭代相减法和辗转相除法结合：
    时间复杂度:O(log2(max(x,y)))
    对于x和y来说，如果y=k*y1,x=k*x1,则f(x,y)=k*f(x1,y1);
    如果x=p*x1,假设p为素数，y%p!=0则f(x,y)=f(p*x1,y)=f(x1,y).
    取p=2，做以下分析：
    如果x偶y偶，f(x,y)=2*f(x>>1,y>>1);
    如果x偶y奇，f(x,y)=f(x>>1,y);
    如果x奇y偶，f(x,y)=f(x,y>>1);
    如果x奇y奇，f(x,y)=f(x,x-y),之后x-y偶则下一步有移位操作。
     */

    /**
     * 辗转相除法解最大公约数问题
     * 性能瓶颈：取模运算开销较大
     * @param x 数x
     * @param y 数y
     * @return 数x和数y的最大公约数
     */
    public static int gcd0(int x,int y){
        return (y==0)?x:gcd0(y,x%y);
    }


    /**
     * 相减法解最大公约数问题
     * 性能瓶颈：迭代次数增多
     * @param x 数x
     * @param y 数y
     * @return 数x和数y的最大公约数
     */
    public static int gcd1(int x,int y){
        if(x<y)
            return gcd1(y,x);
        if(y==0)
            return x;
        else
            return gcd1(x-y,y);
    }

    /**
     * 迭代相减法和辗转相除法结合解最大公约数问题
     * 时间复杂度:O(log2(max(x,y)))
     * @param x 数x
     * @param y 数y
     * @return 数x和数y的最大公约数
     */
    public static int gcd2(int x,int y){
        if(x<y)
            return gcd2(y,x);
        if(y==0)
            return x;
        else{
            if(x%2==0){
                if(y%2==0)
                    return (gcd2(x>>1,y>>1)<<1);//x偶y偶
                else
                    return gcd2(x>>1,y);//x偶y奇
            }else{
                if(y%2==0)//x奇y偶
                    return gcd2(x,y>>1);
                else
                    return gcd2(y,x-y);//x奇y奇
            }
        }
    }

    static public int getGCD(int x,int y){
        return gcd2(x,y);
    }

    static public int getLCM(int x,int y){
        int gcd = getGCD(x,y);
        int lcm = x*y/gcd;
        return lcm;
    }

    static public int getArrayGCD(int[] arr){
        int gcd = arr[0];
        for(int i=1;i<arr.length;i++){
            gcd = getGCD(gcd,arr[i]);
        }
        return gcd;
    }

    static public int getArrayLCM(int[] arr){
        int lcm = 1;
        int gcd = getArrayGCD(arr);
        for(int i=0;i<arr.length;i++){
            lcm = getLCM(lcm,arr[i]);
        }
        return lcm;
    }
}
