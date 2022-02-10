package design.proxy;

public class Main {

    public static void main(String[] args) {
        Subject proxy = new SubjectProxy();
        proxy.print();
    }
}
