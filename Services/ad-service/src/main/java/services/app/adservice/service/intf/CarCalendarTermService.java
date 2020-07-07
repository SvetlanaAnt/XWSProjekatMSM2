package services.app.adservice.service.intf;

import org.joda.time.DateTime;
import services.app.adservice.dto.car.CarCalendarTermCreateDTO;
import services.app.adservice.dto.car.CarCalendarTermDTO;
import services.app.adservice.model.CarCalendarTerm;

import java.util.List;

public interface CarCalendarTermService {
    CarCalendarTerm findById(Long id);

    List<CarCalendarTerm> findAll();

    CarCalendarTerm save(CarCalendarTerm carCalendarTerm);

    void delete(CarCalendarTerm carCalendarTerm);

    CarCalendarTerm edit(CarCalendarTerm carCalendarTerm);

    Integer deleteById(Long id);

    CarCalendarTerm createCarCalendarTerm(CarCalendarTermCreateDTO carCalendarTermCreateDTO);

    Integer addCarCalendarTerm(CarCalendarTermDTO carCalendarTermDTO);

    CarCalendarTerm editCarCalendarTerm(CarCalendarTerm carCalendarTerm);

    List<CarCalendarTermCreateDTO> findByAdId(Long id);

    Boolean splitCarCalendarTerm(Long adId, DateTime startDate, DateTime endDate);

    Boolean canSplitCarCalendarTerm(Long adId, DateTime startDate, DateTime endDate);
}
