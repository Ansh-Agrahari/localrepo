package mbm.services;

public class Service {
    public static String processTypeB() {
        // MBM type B service logic
        return "MBM type B service processed";
    }

    public static String handleService(String serviceType) {
        if (serviceType == null) {
            return "service type required";
        }
        if ("b".equalsIgnoreCase(serviceType) || "typeb".equalsIgnoreCase(serviceType) || "type_b".equalsIgnoreCase(serviceType)) {
            return processTypeB();
        }
        return "unsupported service type";
    }
}
