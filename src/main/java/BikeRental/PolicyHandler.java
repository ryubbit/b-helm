package BikeRental;

import BikeRental.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    HelmRepository helmRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRentalCancelled_ReserveCancel(@Payload RentalCancelled rentalCancelled){

        if(rentalCancelled.isMe()){
            System.out.println("##### listener ReserveCancel : " + rentalCancelled.toJson());

            Helm helm = new Helm();
            helm.setId(rentalCancelled.getHelmId());
            // helm.setStatus(rentalCancelled.getStatus());

            helm.setStatus("returned");
            helmRepository.save(helm);
        }
    }

}
