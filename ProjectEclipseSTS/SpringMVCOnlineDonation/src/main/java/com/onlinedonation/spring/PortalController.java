package com.onlinedonation.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlinedonation.util.finalConstantParameter;

@Controller
public class PortalController {

	@RequestMapping(value = "irPortal", method = RequestMethod.GET)
	public ModelAndView cargarPortalInicial() {
		ModelAndView mac = new ModelAndView();
		mac.setViewName("portalInicial");
		mac.addObject("msjBienvenida", finalConstantParameter.STRING_MSJ_BIENVENIDA);
		return mac;
	}

}
