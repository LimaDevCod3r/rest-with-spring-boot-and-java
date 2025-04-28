package br.LimaDevCod3r.Controllers;

import br.LimaDevCod3r.Math.SimpleMath;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/math") // Define o path base para o controlador
public class MathController {

    private SimpleMath simpleMath;

    public MathController(SimpleMath simpleMath) {
        this.simpleMath = simpleMath;
    }

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) {
        return this.simpleMath.sum(numberOne, numberTwo);
    }


    @RequestMapping(value = "subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {
        return this.simpleMath.subtraction(numberOne, numberTwo);
    }


    @RequestMapping(value = "multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                                 @PathVariable("numberTwo") String numberTwo) {
        return this.simpleMath.multiplication(numberOne, numberTwo);
    }

    @RequestMapping(value = "division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) throws Exception {
        return this.simpleMath.division(numberOne, numberTwo);
    }

    @RequestMapping(value = "mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne,
                       @PathVariable("numberTwo") String numberTwo) throws Exception {
        return this.simpleMath.mean(numberOne, numberTwo);
    }

    @RequestMapping(value = "squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        return this.simpleMath.squareroot(number);
    }


}
