package hystrix;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HystrixCommandEnum {

    MOCK1("mock",50);

    private String name;
    private Integer timeout;
}
