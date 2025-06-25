package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/subscribers")
@Transactional
public class SubscriberController {

    @Autowired
    SubscriberRepository subscriberRepository;

    @RequestMapping(
        value = "/subscribersregistersubscriber",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Subscriber registerSubscriber(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RegisterSubscriberCommand registerSubscriberCommand
    ) throws Exception {
        System.out.println(
            "##### /subscriber/registerSubscriber  called #####"
        );
        Subscriber subscriber = new Subscriber();
        subscriber.registerSubscriber(registerSubscriberCommand);
        subscriberRepository.save(subscriber);
        return subscriber;
    }

    @RequestMapping(
        value = "/subscribersusepointforbook",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Subscriber usePointForBook(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UsePointForBookCommand usePointForBookCommand
    ) throws Exception {
        System.out.println("##### /subscriber/usePointForBook  called #####");
        Subscriber subscriber = new Subscriber();
        subscriber.usePointForBook(usePointForBookCommand);
        subscriberRepository.save(subscriber);
        return subscriber;
    }

    @RequestMapping(
        value = "/subscribersverifyktmember",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Subscriber verifyKtMember(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody VerifyKtMemberCommand verifyKtMemberCommand
    ) throws Exception {
        System.out.println("##### /subscriber/verifyKtMember  called #####");
        Subscriber subscriber = new Subscriber();
        subscriber.verifyKtMember(verifyKtMemberCommand);
        subscriberRepository.save(subscriber);
        return subscriber;
    }
}
//>>> Clean Arch / Inbound Adaptor
