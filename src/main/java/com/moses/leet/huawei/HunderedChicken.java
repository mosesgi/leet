package com.moses.leet.huawei;

import java.util.List;
import java.util.Scanner;

/**
 *

 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？

 详细描述：

 接口说明

 原型：

 int GetResult(vector &list)

 输入参数：

 无

 输出参数（指针指向的内存区域保证有效）：

 list  鸡翁、鸡母、鸡雏组合的列表

 返回值：

 -1 失败

 0 成功




 输入描述:

 输入任何一个整数，即可运行程序。

 输出描述:



 示例1
 输入
 复制

 1

 输出
 复制

 0 25 75
 4 18 78
 8 11 81
 12 4 84


 */
public class HunderedChicken {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextInt()) {
            scan.nextInt();
            for (int i = 0; i <= 100; i++) {
                int a = 5 * i;
                for (int j = 0; j <= 100 - i; j++) {
                    int b = 3 * j;
                    if (a + b > 100) {
                        continue;
                    }
                    int remain = 100 - a - b;
                    if (remain * 3 + i + j == 100) {
                        System.out.println(i + " " + j + " " + remain * 3);
                    }
                }
            }
        }
        scan.close();
    }

}
