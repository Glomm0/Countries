/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package countries.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author а353
 */
@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler
public String handleException(
Exception ex, Model m){
m.addAttribute("errorMsg",ex.getMessage());
m.addAttribute("err",ex);
return "globalerror";
}
}