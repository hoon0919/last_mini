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
// @RequestMapping(value="/payments")
@Transactional
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @RequestMapping(
        value = "/paymentsrequestpointpayment",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Payment requestPointPayment(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RequestPointPaymentCommand requestPointPaymentCommand
    ) throws Exception {
        System.out.println("##### /payment/requestPointPayment  called #####");
        Payment payment = new Payment();
        payment.requestPointPayment(requestPointPaymentCommand);
        paymentRepository.save(payment);
        return payment;
    }

    @RequestMapping(
        value = "/paymentscompletepayment",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Payment completePayment(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CompletePaymentCommand completePaymentCommand
    ) throws Exception {
        System.out.println("##### /payment/completePayment  called #####");
        Payment payment = new Payment();
        payment.completePayment(completePaymentCommand);
        paymentRepository.save(payment);
        return payment;
    }

    @RequestMapping(
        value = "/paymentsrequestcardpayment",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Payment requestCardPayment(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RequestCardPaymentCommand requestCardPaymentCommand
    ) throws Exception {
        System.out.println("##### /payment/requestCardPayment  called #####");
        Payment payment = new Payment();
        payment.requestCardPayment(requestCardPaymentCommand);
        paymentRepository.save(payment);
        return payment;
    }

    @RequestMapping(
        value = "/paymentsfailpayment",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Payment failPayment(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody FailPaymentCommand failPaymentCommand
    ) throws Exception {
        System.out.println("##### /payment/failPayment  called #####");
        Payment payment = new Payment();
        payment.failPayment(failPaymentCommand);
        paymentRepository.save(payment);
        return payment;
    }
}
//>>> Clean Arch / Inbound Adaptor
