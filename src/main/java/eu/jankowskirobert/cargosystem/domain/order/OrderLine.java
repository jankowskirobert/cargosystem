package eu.jankowskirobert.cargosystem.domain.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderLine {

    private Product product;
    private long quantity;
    private OrderPolicy policy;
    public static OrderLine create(final Product product,final long quantity, final OrderPolicy orderPolicy){
        OrderLine orderLine = new OrderLine(product, quantity, orderPolicy);

        return orderLine;
    }

    private void increaseQuantity(){
        this.quantity+=1;
    }
}
