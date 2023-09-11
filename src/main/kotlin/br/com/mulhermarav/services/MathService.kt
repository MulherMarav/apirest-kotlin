package br.com.mulhermarav.services

import br.com.mulhermarav.converters.NumberConverter.convertToDouble
import br.com.mulhermarav.validations.NumberValidation.isMathOperationException
import org.springframework.stereotype.Service

@Service
class MathService {

    fun sum(numberOne: String?, numberTwo: String?): Double {
        isMathOperationException(numberOne, numberTwo)

        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    fun multi(numberOne: String?, numberTwo: String?): Double {
        isMathOperationException(numberOne, numberTwo)

        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    fun sub(numberOne: String?, numberTwo: String?): Double {
        isMathOperationException(numberOne, numberTwo)

        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    fun div(numberOne: String?, numberTwo: String?): Double {
        isMathOperationException(numberOne, numberTwo)

        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    fun sqrt(number: String?): Double {
        isMathOperationException(number)

        return kotlin.math.sqrt(convertToDouble(number))
    }

    fun average(numberOne: String?, numberTwo: String?): Double {
        isMathOperationException(numberOne, numberTwo)

        return convertToDouble(numberOne) + convertToDouble(numberTwo) / 2
    }

}