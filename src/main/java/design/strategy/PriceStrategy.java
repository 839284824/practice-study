package design.strategy;

import java.math.BigDecimal;

public interface PriceStrategy {



    /**
     * 计算应付价格
     * @param oriPrice 原始价格
     * @return 计算之后的价格
     */
    BigDecimal quote(BigDecimal oriPrice);
}
