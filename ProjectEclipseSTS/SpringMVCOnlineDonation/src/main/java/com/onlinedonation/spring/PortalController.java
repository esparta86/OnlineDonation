package com.onlinedonation.spring;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.onlinedonation.bean.Usuario;
import com.onlinedonation.service.SIUsuario;
import com.onlinedonation.service.ServiceUsuarioImp;
import com.onlinedonation.util.finalConstantParameter;

@Controller
public class PortalController {

	@RequestMapping(value = "irPortal", method = RequestMethod.GET)
	public ModelAndView cargarPortalInicial() {
		ModelAndView mac = new ModelAndView();
		mac.setViewName("portalInicial");
		mac.addObject("msjBienvenida", finalConstantParameter.STRING_MSJ_BIENVENIDA);
		mac.addObject("cmdusuariologin", new Usuario());

		return mac;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView formJugador(@ModelAttribute("cmdusuariologin") Usuario usuario, BindingResult result,
			SessionStatus status) {
		try {

			if (validateUser(usuario)) {
				ModelAndView amv = new ModelAndView();
				amv.setViewName("mainMenu");
				amv.addObject("usuario", usuario.getUserName());
				return amv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	private Boolean validateUser(Usuario usuario) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/onlinedonation/xml/beans.xml");
		try {
			SIUsuario siUsuario = (SIUsuario) appContext.getBean(ServiceUsuarioImp.class);
			return siUsuario.checkUsuario(usuario);

		} catch (NoSuchBeanDefinitionException e) {
			System.err.println("Bean no encontrado :" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Otro error " + e.getMessage());
		} finally {
			((ConfigurableApplicationContext) appContext).close();
		}
		return Boolean.FALSE;
	}

}
