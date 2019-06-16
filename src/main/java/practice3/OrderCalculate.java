package practice3;


import java.math.BigDecimal;
import java.util.List;

public class OrderCalculate {
    private BigDecimal subTotal;
    private List<OrderLineItem> orderLineItems;
    private List<BigDecimal> discounts;
    private BigDecimal tax;

    public OrderCalculate(Order order) {
        this.orderLineItems = order.getOrderLineItemList();
        this.discounts = order.getDiscounts();
        this.tax = order.getTax();
    }

    public BigDecimal Calculate() {
        subTotal = new BigDecimal(0);
        CalculateSubTotal();
        SubtractDiscounts();
        CalculateTax();
        return subTotal;
    }

    private void CalculateSubTotal() {
        // Total up line items
        for (OrderLineItem lineItem : orderLineItems) {
            subTotal = subTotal.add(lineItem.getPrice());
        }
    }

    private void SubtractDiscounts() {
        // Subtract Discounts
        for (BigDecimal discount : discounts)
            subTotal = subTotal.subtract(discount);
    }

    private void CalculateTax() {
        // Calculate Tax
        BigDecimal tax = subTotal.multiply(this.tax);
        subTotal = subTotal.add(tax);
    }
}
