package com.ss.www.control.Api.Admin;
 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 


@Controller
@RequestMapping(value = "api")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:63342" })
public class ApiUEditorControl {
	/**
	 * @param request
	 * @param response  ×ª·¢jspÒ³Ãæ
	 */
	@RequestMapping(value = "ueditorConfig",method=RequestMethod.GET)
	 public ModelAndView getCompareHomePage() {
        ModelAndView view = new ModelAndView("controller");
        return view;
    }

	
}
