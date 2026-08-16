package food.service;

import food.model.FoodOrder;
import food.model.Discountable;
import food.utility.OrderUtility;

public class OrderService {

    public static void displayAllBills(FoodOrder[] orders) {

        for (FoodOrder order : orders) {

            if (order != null) {

                if (OrderUtility.validateAmount(order.getAmount())
                        && OrderUtility.validateCustomerName(order.getCustomerName())) {

                    OrderUtility.generateOrderSummary(order);

                } else {
                    System.out.println("Invalid order data for Order ID: "
                            + order.getOrderId());
                }
            }
        }
    }

    public static double calculateTotalPayable(FoodOrder[] orders) {

        double total = 0;

        for (FoodOrder order : orders) {

            if (order != null) {

                double discount = 0;

                if (order instanceof Discountable) {
                    discount = ((Discountable) order).applyDiscount();
                }

                total += order.getAmount()
                        - discount
                        + order.calculateDeliveryCharge();
            }
        }

        return total;
    }
}
