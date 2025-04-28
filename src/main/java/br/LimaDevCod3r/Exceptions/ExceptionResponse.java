package br.LimaDevCod3r.Exceptions;

import java.util.Date;

public record ExceptionResponse(
        Date timestamp,
        String message,
        String details
) {

}
