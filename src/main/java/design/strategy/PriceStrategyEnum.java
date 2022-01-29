package design.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PriceStrategyEnum {

    VIP("vip"),
    VVIP("vvip");

    private String type;
}
