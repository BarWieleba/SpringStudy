package eb.study.springstudy.repository;

import java.util.Date;

public interface OwnedVehicleResponse {
    String getBrand();

    String getModel();

    Date getStartDate();

    Date getExpiration();

    Integer getDoorNumber();

    String getStyle();

    String getCity();

    String getStreet();

    Integer getApartmentNumber();

    Integer getHouseNumber();

    String getCarColour();
}
