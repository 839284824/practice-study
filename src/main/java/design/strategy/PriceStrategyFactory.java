package design.strategy;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 保存所有的策略
 */
public class PriceStrategyFactory {

    private static Map<String,PriceStrategy> strategyFactory = new ConcurrentHashMap<>(8);

    public static PriceStrategy getStrategyInstance(String strategyType){
        return strategyFactory.get(strategyType);
    }

    /**注册策略
     * @param strategyType
     * @param strategy
     */
    public static void register(String strategyType,PriceStrategy strategy){
         strategyFactory.put(strategyType, strategy);
    }
}
