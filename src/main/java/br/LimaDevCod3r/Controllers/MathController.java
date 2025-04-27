package br.LimaDevCod3r.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numbOne}/{numbTwo}")
    public Double sum(@PathVariable("numbOne") String numbOne, @PathVariable("numbTwo") String numbTwo){
        return 1D;
    }
}
