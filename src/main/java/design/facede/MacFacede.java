package design.facede;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
public class MacFacede {

    private MacCpu macCpu;
    private MacScreen macScreen;


    public void open(){
        macCpu.open();
        macScreen.open();
    }

}
