package design.strategy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class VVipPriceStrategy implements PriceStrategy, InitializingBean {


    public String getUserType(){
        return PriceStrategyEnum.VVIP.getType();
    }

    /**
     * 计算应付价格
     *
     * @param oriPrice 原始价格
     * @return 计算之后的价格
     */
    @Override
    public BigDecimal quote(BigDecimal oriPrice) {
        return oriPrice.multiply(BigDecimal.valueOf(0.6D));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PriceStrategyFactory.register(getUserType(), new VVipPriceStrategy());
    }
}
