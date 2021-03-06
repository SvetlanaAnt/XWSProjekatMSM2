package services.app.adservice.converter;


import services.app.adservice.dto.car.CarCalendarTermCreateDTO;
import services.app.adservice.dto.car.CarCalendarTermDTO;
import services.app.adservice.dto.car.CarCalendarTermSynchronizeDTO;
import services.app.adservice.dto.sync.CarCalendarTermSyncDTO;
import services.app.adservice.model.CarCalendarTerm;
import services.app.adservice.model.CarCalendarTermSync;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CarCalendarTermConverter extends AbstractConverter {

    public static CarCalendarTerm toCreateCarCalendarTermFromRequest(CarCalendarTermCreateDTO carCalendarTermCreateDTO) {

        return CarCalendarTerm.builder()
                .startDate(DateAPI.DateTimeStringToDateTimeFromFronted(carCalendarTermCreateDTO.getStartDate()))
                .endDate(DateAPI.DateTimeStringToDateTimeFromFronted(carCalendarTermCreateDTO.getEndDate()))
                .build();
    }

    public static CarCalendarTerm toCarCalendarTermFromRequest(CarCalendarTermDTO carCalendarTermDTO) {

        return CarCalendarTerm.builder()
                .startDate(DateAPI.DateTimeStringToDateTimeFromFronted(carCalendarTermDTO.getStartDate()))
                .endDate(DateAPI.DateTimeStringToDateTimeFromFronted(carCalendarTermDTO.getEndDate()))
                .build();
    }

    public static List<CarCalendarTermSynchronizeDTO> toListCarCalendarTermSyncDTOFromListCarCalendarTerm(Set<CarCalendarTerm> carCalendarTermSet) {
        List<CarCalendarTermSynchronizeDTO> carCalendarTermSynchronizeDTOS = new ArrayList<>();
        for (CarCalendarTerm cct : carCalendarTermSet) {
            CarCalendarTermSynchronizeDTO cctDTO = CarCalendarTermSynchronizeDTO.builder()
                    .id(cct.getId())
                    .startDate(DateAPI.DateTimeToStringDateTime(cct.getStartDate()))
                    .endDate(DateAPI.DateTimeToStringDateTime(cct.getEndDate()))
                    .adId(cct.getAd().getId())
                    .build();
            carCalendarTermSynchronizeDTOS.add(cctDTO);
        }

        return carCalendarTermSynchronizeDTOS;
    }

    public static CarCalendarTerm toCarCalendarTermFromCarCalendarTermSyncDTO(CarCalendarTermSyncDTO carCalendarTermSyncDTO) {
        return CarCalendarTerm.builder()
                .startDate(DateAPI.DateTimeStringToDateTime(carCalendarTermSyncDTO.getStartDate()))
                .endDate(DateAPI.DateTimeStringToDateTime(carCalendarTermSyncDTO.getEndDate()))
                .build();
    }

    public static CarCalendarTerm toCarCalendarTermFromCarCalendarTermSync(CarCalendarTermSync carCalendarTermSync) {
        return CarCalendarTerm.builder()
                .startDate(DateAPI.DateTimeStringToDateTime(carCalendarTermSync.getStartDate()))
                .endDate(DateAPI.DateTimeStringToDateTime(carCalendarTermSync.getEndDate()))
                .build();
    }
}
