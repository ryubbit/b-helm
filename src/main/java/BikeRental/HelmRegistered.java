package BikeRental;

public class HelmRegistered extends AbstractEvent {

    private Long id;
    private String status;

    public HelmRegistered(){
        super();
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
