package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.service.OrderService;

public class Main {

    public static void main(String[] args) {

        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Rahul", 500);
        orders[1] = new PremiumOrder(102, "Aman", 800);
        orders[2] = new RegularOrder(103, "Priya", 650);
        orders[3] = new PremiumOrder(104, "Neha", 1000);
        orders[4] = new RegularOrder(105, "Rohan", 450);
        orders[5] = new PremiumOrder(106, "Simran", 1200);

        System.out.println("===== ONLINE FOOD DELIVERY SYSTEM =====");
        System.out.println();

        OrderService.displayAllBills(orders);

        System.out.println();
        FoodOrder.displayTotalOrders();

        System.out.printf("Total Payable Amount: Rs. %.2f%n",
                OrderService.calculateTotalPayable(orders));
    }
}