package agent.app.repository;

import agent.app.model.Ad;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

    Page<Ad> findAllByDeleted(Boolean deleted, Pageable pageable);

    @Query("SELECT ad FROM Ad ad WHERE  ad.deleted=(?1) AND ad.publisherUser.email=(?2)")
    Page<Ad> findAllByDeletedAndPublisherUserEmail(Boolean deleted, String email, Pageable pageable);

    @Query("SELECT ad FROM Ad ad WHERE  ad.deleted=(?1) AND ad.publisherUser.email=(?2)")
    List<Ad> findAllByDeletedAndPublisherUserEmail(Boolean deleted, String email);

    @Query("SELECT ad FROM Ad ad, CarCalendarTerm calendar WHERE calendar.startDate<=(?3) AND calendar.endDate>=(?4) " +
            "AND ad.id = calendar.ad.id AND ad.deleted=(?1) AND ad.location=(?2)")
    Page<Ad> findByDeletedAndLocationAndCarCalendarTermsStartDateBeforeAndCarCalendarTermsEndDateAfter(Boolean deleted, String location, DateTime startDate, DateTime endDate, Pageable pageable);


}
