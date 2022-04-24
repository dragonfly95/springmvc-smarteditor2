package com.system.blog;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloworldController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
    	
    	String[] alpabet = "a,b,c,d,e,f,g,h,i".split(",");
    	List<String> arr = Arrays.asList(alpabet);
    	
    	for (String string : arr) {
			System.out.println(string);
		}
        return "home";
    }
}
