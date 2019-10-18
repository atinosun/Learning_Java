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

    public double buy(int countToBuy) {
        if ( count < countToBuy ) {
            System.out.println("商品库存不够");
            return -1;
        }


        int    fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int    halfPriceCount = countToBuy - fullPriceCount;
        double cost           = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        System.out.println("商品总价为：" + cost + "元。全价商品数目：" + fullPriceCount + "件，半价商品数目：" + halfPriceCount + "件。");
        return cost;
    }

    public double buy() {
        return buy(1);
    }

    //overload
    public double buy(int countToBuy, boolean isVIP) {
        if (this.count < countToBuy) {
            return -1;
        }

        this.count -= countToBuy;
        double totalCost = count * soldPrice;

        if (isVIP) {
            totalCost *= 0.95;
        }

        return totalCost;
    }

    public double buyAndPrintLeft(int countToBuy, boolean printLeft) {
        if ( count < countToBuy ) {
            System.out.println("商品库存不够");
            if ( printLeft ) {
                System.out.println("商品剩余库存为" + count);
            }
            return -1;
        }


        int    fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int    halfPriceCount = countToBuy - fullPriceCount;
        double cost           = soldPrice * fullPriceCount + halfPriceCount * soldPrice / 2;

        System.out.println("商品总价为：" + cost + "元。全价商品数目：" + fullPriceCount + "件，半价商品数目：" + halfPriceCount + "件。");
        return cost;
    }

    public boolean totalValueBiggerThan(Merchandise merchandise) {
        return count * purchasePrice > merchandise.purchasePrice * merchandise.count;
    }

    public boolean isTheBiggestTotalValueOne(LittleSuperMarket littleSuperMarket) {
        double totalValue = count * purchasePrice;
        for ( int i = 0; i < littleSuperMarket.merchandises.length; i++ ) {
            Merchandise m             = littleSuperMarket.merchandises[i];
            double      newTotalValue = m.count * m.purchasePrice;
            if ( totalValue < newTotalValue ) {
                // 执行到return的时候，方法直接结束，不管是不是在循环中，是在第几层循环中。
                return false;
            }
        }
        return true;

    }

}
