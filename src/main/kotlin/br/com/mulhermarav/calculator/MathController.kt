package br.com.mulhermarav.calculator

import br.com.mulhermarav.calculator.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

private const val ERROR_MESSAGE = "Please set a numeric value!"

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw  UnsupportedMathOperationException(ERROR_MESSAGE)

        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/multi/{numberOne}/{numberTwo}"])
    fun multi(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw  UnsupportedMathOperationException(ERROR_MESSAGE)

        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne") numberOne: String?,
              @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw  UnsupportedMathOperationException(ERROR_MESSAGE)

        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw  UnsupportedMathOperationException(ERROR_MESSAGE)

        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/sqrt/{numberOne}"])
    fun sqrt(@PathVariable(value = "numberOne") numberOne: String?): Double {

        if(!isNumeric(numberOne))
            throw  UnsupportedMathOperationException(ERROR_MESSAGE)

        return kotlin.math.sqrt(convertToDouble(numberOne))
    }

    @RequestMapping(value = ["/average/{numberOne}/{numberTwo}"])
    fun average(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw  UnsupportedMathOperationException(ERROR_MESSAGE)

        return convertToDouble(numberOne) + convertToDouble(numberTwo) / 2
    }

    private fun convertToDouble(strNumber: String?): Double {
        if(strNumber.isNullOrBlank()) return 0.0

        val number = strNumber.replace(",".toRegex(), ".")

        return if(isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false

        val number = strNumber.replace(",".toRegex(), ".")

        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }

}