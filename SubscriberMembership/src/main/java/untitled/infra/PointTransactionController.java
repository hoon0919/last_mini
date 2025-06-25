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
// @RequestMapping(value="/pointTransactions")
@Transactional
public class PointTransactionController {

    @Autowired
    PointTransactionRepository pointTransactionRepository;

    @RequestMapping(
        value = "/pointTransactionsgrantdefaultpoint",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PointTransaction grantDefaultPoint(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody GrantDefaultPointCommand grantDefaultPointCommand
    ) throws Exception {
        System.out.println(
            "##### /pointTransaction/grantDefaultPoint  called #####"
        );
        PointTransaction pointTransaction = new PointTransaction();
        pointTransaction.grantDefaultPoint(grantDefaultPointCommand);
        pointTransactionRepository.save(pointTransaction);
        return pointTransaction;
    }

    @RequestMapping(
        value = "/pointTransactionsgrantktextrapoint",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PointTransaction grantKtExtraPoint(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody GrantKtExtraPointCommand grantKtExtraPointCommand
    ) throws Exception {
        System.out.println(
            "##### /pointTransaction/grantKtExtraPoint  called #####"
        );
        PointTransaction pointTransaction = new PointTransaction();
        pointTransaction.grantKtExtraPoint(grantKtExtraPointCommand);
        pointTransactionRepository.save(pointTransaction);
        return pointTransaction;
    }
}
//>>> Clean Arch / Inbound Adaptor
