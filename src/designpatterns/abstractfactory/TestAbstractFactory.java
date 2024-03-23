package designpatterns.abstractfactory;

public class TestAbstractFactory {

    private static void testAbstractFactory() {
        Computer pc = ComputerFactory.getComputer(new PCFactory("16GB", "1TB", "4.0Ghz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("128GB", "10TB", "4Ghz"));
        System.out.println("PC Specs are : " + pc);
        System.out.println("Server specs are : " + server);
    }

    public static void main(String[] args) {
        testAbstractFactory();
    }
}
