package com.hust.bytedance;

import java.util.Scanner;

/**
 * I love you !
 * 读取一行：I love you !
 *
 * love
 * 读取一个单词：love
 *
 * 5
 * 读取一个整数：5
 *
 * 3 1
 * 2
 * 3
 * 读取一个数组：
 * 1 2 3
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
/*        // 读取一行
        String s = sc.nextLine();
        System.out.println("读取一行：" + s);
        // 读取一个单词(有 空格 会报错)
        String next = sc.next();
        System.out.println("读取一个单词："+next);
        // 读取一个整数---注意：nextInt按空格分开 多输出的整数会读取到后面的next.Int中
        int nextInt = sc.nextInt();
        System.out.println("读取一个整数："+nextInt);*/
        // 读取一个数组
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("读取一个数组：");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
