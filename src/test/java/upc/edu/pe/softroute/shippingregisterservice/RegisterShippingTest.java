package upc.edu.pe.softroute.shippingregisterservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import upc.edu.pe.softroute.shippingregisterservice.domain.models.Shipping;
import upc.edu.pe.softroute.shippingregisterservice.dto.ShippingDTO;

public class RegisterShippingTest {

    @Test
    public void testID() {
        Shipping shipping = new Shipping();
        shipping.setId(1L);
        shipping.setShippingDate("26/05/2021");
        shipping.setShippingTime("10:00");
        shipping.setShippingDescription("Cellular Xiaomi Redmi Note 9");
        shipping.setShippingPrice("10");
        // TODO: Add assertions
        Assertions.assertThat(shipping.getId()).isEqualTo(1L);

    }

    @Test
    public void testShippingDate() {
        Shipping shipping = new Shipping();
        shipping.setId(1L);
        shipping.setShippingDate("26/05/2021");
        shipping.setShippingTime("10:00");
        shipping.setShippingDescription("Cellular Xiaomi Redmi Note 9");
        shipping.setShippingPrice("10");

        Assertions.assertThat(shipping.getShippingDate()).isEqualTo("26/05/2021");
    }

    @Test
    public void testShippingTime() {
        Shipping shipping = new Shipping();
        shipping.setId(1L);
        shipping.setShippingDate("26/05/2021");
        shipping.setShippingTime("10:00");
        shipping.setShippingDescription("Cellular Xiaomi Redmi Note 9");
        shipping.setShippingPrice("10");

        Assertions.assertThat(shipping.getShippingTime()).isEqualTo("10:00");
    }

    @Test
    public void testShippingDescription() {
        Shipping shipping = new Shipping();
        shipping.setId(1L);
        shipping.setShippingDate("26/05/2021");
        shipping.setShippingTime("10:00");
        shipping.setShippingDescription("Cellular Xiaomi Redmi Note 9");
        shipping.setShippingPrice("10");

        Assertions.assertThat(shipping.getShippingDescription()).isEqualTo("Cellular Xiaomi Redmi Note 9");
    }
}
