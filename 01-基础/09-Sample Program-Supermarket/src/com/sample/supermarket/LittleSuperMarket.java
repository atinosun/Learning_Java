package com.sample.supermarket;

/**
 * @author: atinosun@yeah.net
 * @date: 2019-10-11
 * @brief: 超市类
 */
public class LittleSuperMarket {
    public String        superMarketName;
    public String        address;
    public int           parkingCount;
    public double        incomingSum;
    public Merchandise[] merchandises;
    public int[]         merchandiseSold;

    public Merchandise getBiggestProfitMerchandise() {
        Merchandise cur = null;
        for ( int i = 0; i < merchandises.length; i++ ) {
            Merchandise m = merchandises[i];
            cur = cur != null ? cur : m;

            double currProfit = cur.calculateProfit();
            double newProfit  = m.calculateProfit();

            cur = currProfit > newProfit ? cur : m;
        }

        return cur;
    }
}
