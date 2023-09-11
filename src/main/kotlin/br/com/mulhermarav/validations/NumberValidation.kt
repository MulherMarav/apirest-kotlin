package br.com.mulhermarav.validations

import br.com.mulhermarav.converters.NumberConverter
import br.com.mulhermarav.exceptions.UnsupportedMathOperationException

private const val ERROR_MESSAGE = "Please set a numeric value!"

object NumberValidation {

    fun isMathOperationException(numberOne: String?, numberTwo: String?) {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException(ERROR_MESSAGE)
    }

    fun isMathOperationException(numberOne: String?) {
        if(!NumberConverter.isNumeric(numberOne))
            throw UnsupportedMathOperationException(ERROR_MESSAGE)
    }
}