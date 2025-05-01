package br.LimaDevCod3r.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestLongController {

    private final Logger logger = LoggerFactory.getLogger(TestLongController.class.getName());

    @GetMapping("/test")
    public String TestLong() {
        logger.debug("This is DEBUG LOG");
        logger.info("This is INFO LOG");
        logger.warn("This is WARN LOG");
        logger.error("This is ERROR LOG");

        return "Logs generated sucessfully!";
    }
}
