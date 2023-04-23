package countries.controller;

import countries.model.Country;
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
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContinentController {
    
    
    @RequestMapping(value="/continent/{code}")
    public String continent(Model model, @PathVariable("code") String code){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("countries");
        context.refresh();
        List<Country> res = new ArrayList();
        CountryRepository CR=context.getBean(CountryRepository.class);
        res=CR.findByContinent(code);
        model.addAttribute("CountriesByContinent",res);
        model.addAttribute("ContinentName",code);
        return "continent";
    }
    

}
