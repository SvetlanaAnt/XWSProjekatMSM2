package agent.app.repository;

import agent.app.model.Request;
import agent.app.model.enumeration.RequestStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    @Query("SELECT req FROM Request req where req.publisherUser.email=(?1) and req.status=(?2) order by req.submitDate desc")
    List<Request> findAllByEndUserAndByStatus(String email, RequestStatusEnum status);
}
