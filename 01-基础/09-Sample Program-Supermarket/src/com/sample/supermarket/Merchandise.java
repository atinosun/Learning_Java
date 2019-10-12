package com.sample.supermarket;

/**
 * @author: atinosun@yeah.net
 * @date: 2019-10-11
 * @brief: 商家类
 */
public class Merchandise {
    public String name;
    public String id;
    public int    count;
    public double soldPrice;
    public double purchasePrice;

    public void describe() {
        double netIncome = soldPrice - purchasePrice;
        System.out.println("商品的名称为" + name + "，id是：" + id + "，售价" + soldPrice + "元，进价" + purchasePrice
                               + "元，库存" + count + "件，单件毛利润为" + netIncome + "元。");
    }

    /**
     * 计算毛利润
     *
     * @return double
     */
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        profit = profit > 0 ? profit : 0;

        return profit;
    }

    public double getCurrentCount() {
        return (double) count;
    }

    public int getIntSoldPrice() {
        return (int) soldPrice;
    }
}
