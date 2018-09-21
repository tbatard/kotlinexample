package com.tarbadev.kotlinexample.kotlinexample

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("/")
class HomeController(private val cipherUseCase: CipherUseCase) {

    @GetMapping
    fun show(): String {
        return "index"
    }

    @PostMapping
    fun cipher(@RequestParam("input") input: String, redirectAttributes: RedirectAttributes): String {
        println("input = $input")
        val ciphered = cipherUseCase.execute(input)
        redirectAttributes.addFlashAttribute("cipheredText", ciphered)

        return "redirect:/"
    }
}