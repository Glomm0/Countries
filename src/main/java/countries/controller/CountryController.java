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
public class CountryController {
    
    
    @RequestMapping(value="/country/{code}")
    public String country(Model model, @PathVariable("code") String code) throws Exception{
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("countries");
        context.refresh();
        Country res ;
        CountryRepository CR=context.getBean(CountryRepository.class);
        res=CR.findByName(code);
        
        if(res==null){
            throw new Exception("Country not Found");
        }
        model.addAttribute("Country",res);
        model.addAttribute("CountryName",code);
        return "country";
        
        
    }
    
    
    

}
