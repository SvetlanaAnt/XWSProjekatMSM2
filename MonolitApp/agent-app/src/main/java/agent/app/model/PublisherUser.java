package agent.app.model;

import agent.app.common.db.DbColumnConstants;
import agent.app.common.db.DbTableConstants;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = DbTableConstants.PUBLISHERUSER)
public class PublisherUser extends User {

    @Column(name = DbColumnConstants.DELETED, nullable = false)
    private Boolean deleted;

    @OneToMany(mappedBy = "publisherUser", fetch = FetchType.LAZY)
    private Set<Ad> ads = new HashSet<>();

    @OneToMany(mappedBy = "publisherUser", fetch = FetchType.LAZY)
    private Set<PriceList> priceLists = new HashSet<>();

    @OneToMany(mappedBy = "publisherUser", fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<>();


    @OneToMany(mappedBy = "publisherUser", fetch = FetchType.LAZY)
    private Set<Report> reports = new HashSet<>();

    @OneToMany(mappedBy = "publisherUser", fetch = FetchType.LAZY)
    private Set<Request> publisherUserRequests = new HashSet<>();

    @Builder(builderMethodName = "publisherUserBuilder")
    public PublisherUser(Long id, String email, String password, String firstName,
                         String lastName, Boolean local, DateTime lastPasswordResetDate,
                         List<Authority> authorities, Boolean deleted, Set<Ad> ads,
                         Set<PriceList> priceLists, Set<Comment> comments, Set<Report> reports, Set<Request> publisherUserRequests) {
        super(id, email, password, firstName, lastName, local, lastPasswordResetDate, authorities);
        this.deleted = deleted;
        this.ads = ads;
        this.priceLists = priceLists;
        this.comments = comments;
        this.reports = reports;
        this.publisherUserRequests = publisherUserRequests;
    }

}