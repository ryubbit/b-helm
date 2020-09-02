package BikeRental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Helm_table")
public class Helm {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String status;

    @PostPersist
    public void onPostPersist(){

        System.out.println("###onPostPersist###");
        HelmRegistered helmRegistered = new HelmRegistered();
        BeanUtils.copyProperties(this, helmRegistered);
        helmRegistered.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate(){

        System.out.println("###onPreUpdate###");
        HelmUpdated helmUpdated = new HelmUpdated();
        BeanUtils.copyProperties(this, helmUpdated);
        helmUpdated.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
