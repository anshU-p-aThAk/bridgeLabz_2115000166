import java.util.*;

class Order {
    protected int orderId;
    protected String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public void getOrderStatus() {
        System.out.println("Order ID: " + orderId + ", Order Date: " + orderDate);
    }
}

class ShippedOrder extends Order {
    protected int trackingNumber;

    public ShippedOrder(int orderId, String orderDate, int trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    protected String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate, int trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

public class OrderManagement {
    public static void main(String[] args) {
        DeliveredOrder deliveredOrder = new DeliveredOrder(123, "2022-01-01", 456, "2022-02-01");
        deliveredOrder.getOrderStatus();
        ShippedOrder shippedOrder = new ShippedOrder(456, "2022-02-01", 789);
        shippedOrder.getOrderStatus();
    }
}
