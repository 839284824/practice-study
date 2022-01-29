package design.strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class Main {

    public static void main(String[] args) {

        //手动创建不同的策略
        PriceStrategy priceStrategy = new VipPriceStrategy();
        log.info("vip price:{}",priceStrategy.quote(BigDecimal.TEN));

        PriceStrategy priceStrategy1 = new VVipPriceStrategy();
        log.info("vvip price:{}",priceStrategy1.quote(BigDecimal.TEN));

        //工厂取策略
        PriceStrategy priceStrategy2 = PriceStrategyFactory.getStrategyInstance(PriceStrategyEnum.VIP.getType());
        log.info("vip price:{}",priceStrategy1.quote(BigDecimal.TEN));



    }
}
