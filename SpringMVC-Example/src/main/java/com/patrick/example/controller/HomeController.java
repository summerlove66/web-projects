package com.patrick.example.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.validation.Valid;

import com.patrick.example.domain.Student;
import com.patrick.example.process.StudentMobileEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        System.out.println("调用 initBinder方法");
        SimpleDateFormat df = new SimpleDateFormat("yyyy--MM--dd");
        binder.registerCustomEditor(Date.class, "studentBdo", new CustomDateEditor(df, false));
        binder.registerCustomEditor(Long.class, "studentMobile", new StudentMobileEditor());
        //	binder.setDisallowedFields(new String[] {"studentMobile","studentAddress.pincode"});
    }


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String home(@RequestParam(value = "username", defaultValue = "hui") String username, Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        model.addAttribute("username", username);
        return "home";
    }

    @RequestMapping("/form")
    public String submit() {

        return "simpleform";
    }

    @RequestMapping("/except")
    public void throwException() throws IOException {


        throw new NullPointerException("you get  the nullpointer  exception");
    }


    @RequestMapping("/submit")
    public String submit(@Valid @ModelAttribute Student student, BindingResult result) throws UnsupportedEncodingException {


        if (result.hasErrors()) {
            System.out.println("result :" + result);
            return "simpleform";

        } else {
            ModelAndView mv = new ModelAndView();
            mv.addObject("student", student);
            return "success";

        }
    }


//	@ExceptionHandler(value= IOException.class)
//	public ModelAndView  handleIOException(Exception e) {
//		System.out.println("handle the IO exception" +e.getMessage());
//		ModelAndView mv = new ModelAndView("exception");
//
//		mv.addObject("exceptiondesc" ,"错误信息 " +e.getMessage());
//		return mv;
//	}


//	@ModelAttribute
//	public void addingCommonObj(Model model) {
//		System.out.println("首先被调用 1");
//		model.addAttribute( "headerMessage", "welcome");
//	}


//	@Override
//	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {	
//		ModelAndView mv = new ModelAndView("home");
//		mv.addObject("serverTime", new Date().toLocaleString() +"----");
//		return mv;
//	}

}
