import lombok.extern.slf4j.Slf4j;
import practice.People;
import practice.Stu;
import practice.Tea;

@Slf4j
public class Main {

    public static void main(String[] a) throws Exception {
        People people = new Stu();
        log.info(people.chat(""));
        People people1 = new Tea();
        log.info(people1.chat(""));
    }


}
