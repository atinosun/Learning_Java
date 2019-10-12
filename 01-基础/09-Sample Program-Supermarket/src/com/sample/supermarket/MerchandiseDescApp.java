package com.sample.supermarket;

/**
 * @author: atinosun@yeah.net
 * @date: 2019-10-12
 * @brief: 商品描述
 */
public class MerchandiseDescApp {
    public static void main(String[] args) {
        Merchandise merchandise = new Merchandise();

        merchandise.name = "书桌";
        merchandise.soldPrice = 999.9;
        merchandise.purchasePrice = 500;
        merchandise.count = 40;
        merchandise.id = "DESK9527";

        merchandise.describe();

    }
}
