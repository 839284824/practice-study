package design.template;

public class Main {

    public static void main(String[] args) {
        Daily stuDaily = new StuDaily();
        stuDaily.daily(stuDaily.getRole());

        Daily coderDaily  = new CoderDaily();
        coderDaily.daily(coderDaily.getRole());

    }
}
