package food.utility;

import food.model.FoodOrder;
import food.model.Discountable;

public class OrderUtility {

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static void generateOrderSummary(FoodOrder order) {

        double discount = 0;

        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }

        double deliveryCharge = order.calculateDeliveryCharge();
        double finalAmount = order.getAmount() - discount + deliveryCharge;

        System.out.println("----------------------------------------");
        System.out.println("Restaurant       : " + FoodOrder.getRestaurantName());
        System.out.println("Order ID         : " + order.getOrderId());
        System.out.println("Customer Name    : " + order.getCustomerName());
        System.out.printf("Order Amount     : Rs. %.2f%n", order.getAmount());
        System.out.printf("Discount         : Rs. %.2f%n", discount);
        System.out.printf("Delivery Charge  : Rs. %.2f%n", deliveryCharge);
        System.out.printf("Final Payable    : Rs. %.2f%n", finalAmount);
        System.out.println("----------------------------------------");
    }
}