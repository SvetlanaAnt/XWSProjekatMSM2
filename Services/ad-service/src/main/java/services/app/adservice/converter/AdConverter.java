package services.app.adservice.converter;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import services.app.adservice.dto.ad.AdCreateDTO;
import services.app.adservice.dto.ad.AdDetailViewDTO;
import services.app.adservice.dto.ad.AdPageDTO;
import services.app.adservice.dto.ad.AdSynchronizeDTO;
import services.app.adservice.model.Ad;
import services.app.adservice.model.enumeration.DistanceLimitEnum;

import java.io.File;
import java.util.Base64;
import java.util.HashSet;

public class AdConverter extends AbstractConverter {

    @Value("${directory.prop}")
    private String photoDir;

    public static Ad toCreateAdFromRequest(AdCreateDTO adCreateDTO) {
        DistanceLimitEnum distanceLimitEnum = null;
        if (adCreateDTO.getDistanceLimitFlag().equals("false")) {
            System.out.println("izabrano je unlimited");
            distanceLimitEnum = DistanceLimitEnum.UNLIMITED;
        } else if (adCreateDTO.getDistanceLimitFlag().equals("true")) {
            System.out.println("izabrano je limited");
            distanceLimitEnum = DistanceLimitEnum.LIMITED;
        } else {
            System.out.println("Nije nista");
        }
        return Ad.builder()
                .name(adCreateDTO.getName())
                .location(adCreateDTO.getLocation())
                .coverPhoto(adCreateDTO.getCoverPhoto())
                .distanceLimitFlag(distanceLimitEnum)
                .distanceLimit(adCreateDTO.getDistanceLimit())
                .publishedDate(DateAPI.DateTimeNow())
                .deleted(false)
                .enabled(true)
                .discountLists(new HashSet<>())
//                .requests(new HashSet<>())
                .comments(new HashSet<>())
                .carCalendarTerms(new HashSet<>())
                .rentCnt(0L)
                .ratingCnt(0L)
                .ratingNum(0L)
                .build();
    }

    public static AdPageDTO toCreateAdPageDTOFromAd(Ad ad) {
        String encodedString = "";
        try {
            byte[] fileContent = fileContent = FileUtils.readFileToByteArray(new File("C:\\XMLPhotos\\adService\\" + ad.getCoverPhoto()));
            encodedString = Base64.getEncoder().encodeToString(fileContent);
        } catch (Exception e) {
            encodedString = "Nije uspjelo";
        }
        return AdPageDTO.builder()
                .id(ad.getId())
                .name(ad.getName())
                .location(ad.getLocation())
                .coverPhoto(encodedString)
//                .price(ad.getPriceList().getPricePerDay())
                .carManufacturer(ad.getCar().getCarManufacturer())
                .carModel(ad.getCar().getCarModel())
                .childrenSeatNum(ad.getCar().getChildrenSeatNum())
                .fuelType(ad.getCar().getFuelType())
                .mileage(ad.getCar().getMileage())
                .build();
    }

    public static AdDetailViewDTO toAdDetailViewDTOFromAd(Ad ad) {
        String encodedString = "";
        try {
            byte[] fileContent = fileContent = FileUtils.readFileToByteArray(new File("C:\\XMLPhotos\\adService\\" + ad.getCoverPhoto()));
            encodedString = Base64.getEncoder().encodeToString(fileContent);
        } catch (Exception e) {
            encodedString = "Nije uspjelo";
        }
        return AdDetailViewDTO.builder()
                .id(ad.getId())
                .name(ad.getName())
                .location(ad.getLocation())
                .coverPhoto(encodedString)
                .publishedDate(ad.getPublishedDate().toString())
                .ratingNum(ad.getRatingNum())
                .ratingCnt(ad.getRatingCnt())
                .rentCnt(ad.getRentCnt())
                .distanceLimitFlag(ad.getDistanceLimitFlag().toString())
                .year(ad.getCar().getYear().toString())
                .distanceLimit(ad.getDistanceLimit())
                .carManufacturer(ad.getCar().getCarManufacturer())
                .carModel(ad.getCar().getCarModel())
                .gearboxType(ad.getCar().getGearboxType())
                .fuelType(ad.getCar().getFuelType())
                .carType(ad.getCar().getCarType())
                .mileage(ad.getCar().getMileage())
                .childrenSeatNum(ad.getCar().getChildrenSeatNum())
                .cdw(ad.getCar().getCdw())
                .androidFlag(ad.getCar().getAndroidFlag())
//                .pricePerKm(ad.getPriceList().getPricePerKm())
//                .pricePerKmCDW(ad.getPriceList().getPricePerKmCDW())
//                .pricePerDay(ad.getPriceList().getPricePerDay())
                .publisherUserId(ad.getPublisherUser())
//                .publisherUserFirstName(ad.getPublisherUser().getFirstName())
//                .publisherUserLastName(ad.getPublisherUser().getLastName())
                .build();
    }

    public static AdSynchronizeDTO toAdSynchronizeDTOFromAd(Ad ad) {

        return AdSynchronizeDTO.builder()
                .id(ad.getId())
                .name(ad.getName())
                .location(ad.getLocation())
                .coverPhoto(ad.getCoverPhoto())
//                .imagesSynchronizeDTOS(ImageConverter.toImagesSynchronizeDTOFromImages(ad.getImages()))
                .distanceLimitFlag(ad.getDistanceLimitFlag().toString())
                .distanceLimit(ad.getDistanceLimit())
                .publishedDate(ad.getPublishedDate().toString())
                .ratingNum(ad.getRatingNum())
                .ratingCnt(ad.getRatingCnt())
                .deleted(ad.getDeleted())
                .enabled(ad.getEnabled())
                .rentCnt(ad.getRentCnt())
//                .pricePerDay()
                .publisherUser(ad.getPublisherUser())
                .carSynchronizeDTO(CarConverter.toCarSynchronizeDTOFromCar(ad.getCar()))
                .carCalendarTermSynchronizeDTOS(CarCalendarTermConverter.toListCarCalendarTermSyncDTOFromListCarCalendarTerm(ad.getCarCalendarTerms()))
                .build();

    }
}
