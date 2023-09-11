package br.com.mulhermarav.controllers

import br.com.mulhermarav.services.MathService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    val mathService: MathService = MathService()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        return mathService.sum(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/multi/{numberOne}/{numberTwo}"])
    fun multi(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        return mathService.multi(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne") numberOne: String?,
              @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        return mathService.sub(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        return mathService.div(numberOne, numberTwo)
    }

    @RequestMapping(value = ["/sqrt/{number}"])
    fun sqrt(@PathVariable(value = "number") number: String?): Double {

        return mathService.sqrt(number)
    }

    @RequestMapping(value = ["/average/{numberOne}/{numberTwo}"])
    fun average(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?): Double {

        return mathService.average(numberOne, numberTwo)
    }

}