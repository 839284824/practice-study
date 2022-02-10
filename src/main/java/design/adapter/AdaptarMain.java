package design.adapter;

public class AdaptarMain {

    public static void main(String[] args) {
        Target target = new Adaptar(new Adaptee());
        target.say();
    }
}
