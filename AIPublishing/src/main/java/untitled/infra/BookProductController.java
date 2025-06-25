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
// @RequestMapping(value="/bookProducts")
@Transactional
public class BookProductController {

    @Autowired
    BookProductRepository bookProductRepository;

    @RequestMapping(
        value = "/bookProductscreatebookproduct",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public BookProduct createBookProduct(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreateBookProductCommand createBookProductCommand
    ) throws Exception {
        System.out.println(
            "##### /bookProduct/createBookProduct  called #####"
        );
        BookProduct bookProduct = new BookProduct();
        bookProduct.createBookProduct(createBookProductCommand);
        bookProductRepository.save(bookProduct);
        return bookProduct;
    }
}
//>>> Clean Arch / Inbound Adaptor
