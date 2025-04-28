package br.LimaDevCod3r.Math;

import br.LimaDevCod3r.Exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

import static br.LimaDevCod3r.Utils.NumberConverter.covertToDouble;
import static br.LimaDevCod3r.Utils.NumberConverter.isNumeric;

@Service
public class SimpleMath {
    public Double sum(String numberOne, String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        Double numb1 = covertToDouble(numberOne);
        Double numb2 = covertToDouble(numberTwo);

        return numb1 + numb2;
    }

    public Double subtraction(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double numb1 = covertToDouble(numberOne);
        Double numb2 = covertToDouble(numberTwo);

        return numb1 - numb2;
    }

    public Double multiplication(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double numb1 = covertToDouble(numberOne);
        Double numb2 = covertToDouble(numberTwo);

        return numb1 * numb2;
    }

    public Double division(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        if (covertToDouble(numberTwo) == 0.0) {
            throw new UnsupportedMathOperationException("Cannot divide by 0");
        }

        Double numb1 = covertToDouble(numberOne);
        Double numb2 = covertToDouble(numberTwo);

        return numb1 / numb2;
    }

    public Double mean(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }


        Double numb1 = covertToDouble(numberOne);
        Double numb2 = covertToDouble(numberTwo);

        return (numb1 + numb2) / 2;
    }

    public Double squareroot(String number) {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        if (covertToDouble(number) < 0) {
            throw new UnsupportedMathOperationException("Cannot calculate square root of negative number");
        }

        Double numb1 = covertToDouble(number);

        return Math.sqrt(numb1);
    }
}
