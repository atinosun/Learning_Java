package com.sample;

import com.sample.person.Customer;
import com.sample.supermarket.LittleSuperMarket;
import com.sample.supermarket.Merchandise;

import java.util.Scanner;

/**
 * @author: atinosun@yeah.net
 * @date: 2019-10-11
 * @brief:
 */
public class SuperMarketApp {
    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        //超市基本属性赋值
        littleSuperMarket.superMarketName = "小超市";
        littleSuperMarket.address = "北京市";
        littleSuperMarket.parkingCount = 100;
        //200种商品
        littleSuperMarket.merchandises = new Merchandise[200];
        //统计用数组
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        //为了方便使用，新增一个数组引用
        Merchandise[] all = littleSuperMarket.merchandises;

        //循环赋值商品
        for ( int i = 0; i < all.length; i++ ) {
            Merchandise m = new Merchandise();
            m.name = "商品" + i;
            m.count = 200;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            all[i] = m;
        }

        System.out.println("下面请利润最高的商品自我介绍：");
        littleSuperMarket.getBiggestProfitMerchandise().describe();
        System.out.println("超市开张了!");

        boolean open  = true;
        Scanner input = new Scanner(System.in);
        while ( open ) {
            System.out.println("本店叫做" + littleSuperMarket.superMarketName);
            System.out.println("地址在" + littleSuperMarket.address);
            System.out.println("共有停车位" + littleSuperMarket.parkingCount);
            System.out.println("今天的营业额为" + littleSuperMarket.incomingSum);
            System.out.println("共有商品" + littleSuperMarket.merchandises.length + "种");

            //顾客行为
            Customer customer = new Customer();
            customer.name = "顾客编号" + ((int) (Math.random() * 10000000));
            customer.money = (1 + Math.random()) * 10000;
            customer.isDrivingCar = Math.random() > 0.5;
            String extraWelMsg = "";

            //开车的顾客，有空余车位才可以进入购物
            if ( customer.isDrivingCar && littleSuperMarket.parkingCount <= 0 ) {
                System.out.println("不好意思，本店车位已满，欢迎您下次光临！");
                continue;
            }

            if ( customer.isDrivingCar && littleSuperMarket.parkingCount > 0 ) {
                extraWelMsg = "驾车而来。本店已经为您安排了车位，停车免费哦。车位编号为" + littleSuperMarket.parkingCount + ".";
                littleSuperMarket.parkingCount--;
            }

            extraWelMsg = extraWelMsg.length() > 0 ? extraWelMsg : "光临";
            System.out.println("欢迎" + customer.name + extraWelMsg);

            //接待顾客
            double totalCost = 0;
            while ( true ) {
                System.out.println("本店提供" + littleSuperMarket.merchandises.length + "种商品，请输入您要购买的商品编号：");
                int merchandiseId = input.nextInt();
                //负数中断购物
                if ( merchandiseId < 0 ) {
                    System.out.println("您本次购买了" + totalCost + "元商品。期待您下次光临！");
                    break;
                }

                if ( merchandiseId > littleSuperMarket.merchandises.length ) {
                    System.out.println("商品编号不存在，请确认后重试！");
                    continue;
                }

                //待选商品
                Merchandise toBuy = littleSuperMarket.merchandises[merchandiseId];
                System.out.println(toBuy.name + "单价" + toBuy.soldPrice + "元。请输入购买数量：");

                int numToBuy = input.nextInt();

                if ( numToBuy <= 0 ) {
                    continue;
                }

                if ( numToBuy > toBuy.count ) {
                    System.out.println("库存不足，余量为" + toBuy.count + "件，请重新选购。");
                    continue;
                }

                if ( numToBuy * toBuy.soldPrice + totalCost > customer.money ) {
                    System.out.println("余额不足，请重新挑选。");
                    continue;
                }

                totalCost += numToBuy * toBuy.soldPrice;
                toBuy.count -= numToBuy;
                littleSuperMarket.merchandiseSold[merchandiseId] += numToBuy;

            }

            if ( customer.isDrivingCar ) {
                littleSuperMarket.parkingCount++;
            }

            customer.money -= totalCost;
            littleSuperMarket.incomingSum += totalCost;
            System.out.println(customer.name + "共消费" + totalCost + "元，期待您下次光临！");

            System.out.println("是否继续营业？");

            open = input.nextBoolean();

        }

        System.out.println("超市打烊了。今日销售额为" + littleSuperMarket.incomingSum + "。详细数据如下：");

        for ( int i = 0; i < littleSuperMarket.merchandiseSold.length; i++ ) {
            int sold = littleSuperMarket.merchandiseSold[i];

            if ( sold > 0 ) {
                Merchandise m           = littleSuperMarket.merchandises[i];
                double      netIncoming = sold * (m.soldPrice - m.purchasePrice);
                double      incoming    = sold * m.soldPrice;
                System.out.println(littleSuperMarket.merchandises[i].name + "售出"
                                       + sold + "件，销售额" + incoming + "元，毛利润" + netIncoming + "元。");
            }
        }

    }

}
