package design.facede;

public class FacedeMain {

    public static void main(String[] args) {

        MacFacede macFacede = MacFacede.builder()
                .macCpu(new MacCpu())
                .macScreen(new MacScreen())
                .build();
        macFacede.open();
    }
}
