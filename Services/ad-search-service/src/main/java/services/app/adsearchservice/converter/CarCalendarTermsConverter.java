package services.app.adsearchservice.converter;

import services.app.adsearchservice.dto.car.CarCalendarTermSynchronizeDTO;
import services.app.adsearchservice.model.CarCalendarTerm;

public class CarCalendarTermsConverter {

    public static CarCalendarTerm toCarCalendarTermFromSyncDTO(CarCalendarTermSynchronizeDTO dto){
        return CarCalendarTerm.builder()
                .id(dto.getId())
                .startDate(DateAPI.DateTimeStringToDateTime(dto.getStartDate()))
                .endDate(DateAPI.DateTimeStringToDateTime(dto.getEndDate()))
                .build();
    }
}
