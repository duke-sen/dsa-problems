package designpatterns.singleton;

public class BillPughSingleton {
    private BillPughSingleton(){}

    private static class BillPughSingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return BillPughSingletonHelper.INSTANCE;
    }
}
