package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    SubscriberRepository subscriberRepository;

    @Autowired
    PointTransactionRepository pointTransactionRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='KtMemberVerified'"
    )
    public void wheneverKtMemberVerified_GrantKtExtraPointOnKtMemberVerifiedPolicy(
        @Payload KtMemberVerified ktMemberVerified
    ) {
        KtMemberVerified event = ktMemberVerified;
        System.out.println(
            "\n\n##### listener GrantKtExtraPointOnKtMemberVerifiedPolicy : " +
            ktMemberVerified +
            "\n\n"
        );
        // Comments //
        //KT 고객 인증 완료 시 추가 포인트를 지급하여 KT 고객의 서비스 충성도를 높임

        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SubscriberRegistered'"
    )
    public void wheneverSubscriberRegistered_GrantDefaultPointOnSubscriberRegisteredPolicy(
        @Payload SubscriberRegistered subscriberRegistered
    ) {
        SubscriberRegistered event = subscriberRegistered;
        System.out.println(
            "\n\n##### listener GrantDefaultPointOnSubscriberRegisteredPolicy : " +
            subscriberRegistered +
            "\n\n"
        );
        // Comments //
        //신규 회원 가입 완료 시 기본 포인트를 자동으로 지급하여 초기 서비스 이용을 유도함

        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
