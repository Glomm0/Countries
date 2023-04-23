package countries.controller;

import countries.model.CountryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
    @RequestMapping(value="/")
    public String home(){
        return "home";
    }
    @ModelAttribute("Continents")
    public List<String> getContinents(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("countries");
        context.refresh();
        List<String> res = new ArrayList();
        CountryRepository CR=context.getBean(CountryRepository.class);
        return CR.getContinents();
    }

}
