package by.academy.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class OrderObject {
    /**
     * field which needs to sort objects.
     */
    private String orderField;
    /**
     * descending or ascending type of ordering.
     */
    private OrderType orderType;
}
