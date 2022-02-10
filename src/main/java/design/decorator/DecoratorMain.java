package design.decorator;

public class DecoratorMain {


    public static void main(String[] args) {
        Component decorator = new Decorator(new RealComponent());
        decorator.say();
    }
}
