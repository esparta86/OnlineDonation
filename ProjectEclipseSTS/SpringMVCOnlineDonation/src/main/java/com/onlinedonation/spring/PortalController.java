package com.onlinedonation.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.onlinedonation.bean.Donation;
import com.onlinedonation.bean.Usuario;
import com.onlinedonation.service.SIDonation;
import com.onlinedonation.service.SIUsuario;
import com.onlinedonation.service.ServiceDonationImp;
import com.onlinedonation.service.ServiceUsuarioImp;
import com.onlinedonation.util.finalConstantParameter;
import com.onlinedonation.validator.UserValidator;

@Controller
@SessionAttributes("idUsuario")
public class PortalController {

	private UserValidator userValidator;

	public PortalController() {
		this.userValidator = new UserValidator();
	}

	@RequestMapping(value = "irPortal", method = RequestMethod.GET)
	public ModelAndView cargarPortalInicial() {
		ModelAndView mac = new ModelAndView();
		mac.setViewName("portalInicial");
		mac.addObject("msjBienvenida", finalConstantParameter.STRING_MSJ_BIENVENIDA);
		mac.addObject("cmdusuariologin", new Usuario());

		return mac;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView formLogin(@ModelAttribute("cmdusuariologin") Usuario usuario, BindingResult result,
			SessionStatus status) {
		this.userValidator.validate(usuario, result);
		ModelAndView amv = new ModelAndView();
		if (result.hasErrors()) {
			amv.addObject("msjBienvenida", finalConstantParameter.STRING_MSJ_BIENVENIDA);
			amv.setViewName("portalInicial");
			amv.addObject("cmdusuariologin", usuario);

		} else {

			try {
				Integer idUsuario = validateUser(usuario);

				if (idUsuario != null) {
					// Retrieve all donations of user
					usuario.setIdUsuario(idUsuario);
					List<Donation> listaD = allDonation(usuario);

					amv.setViewName("mainMenu");
					amv.addObject("usuario", usuario.getUserName());
					amv.addObject("listaDonation", listaD);
					amv.addObject("idUsuario", idUsuario);

					// return amv;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return amv;

	}

	private List<Donation> allDonation(Usuario usuario) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/onlinedonation/xml/beans.xml");
		List<Donation> lista = new ArrayList<>();
		try {
			SIDonation siDonation = (SIDonation) appContext.getBean(ServiceDonationImp.class);
			lista = siDonation.retrieveAllDonation(usuario);

		} catch (NoSuchBeanDefinitionException e) {
			System.err.println("Bean no encontrado :" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Otro error " + e.getMessage());
		} finally {
			((ConfigurableApplicationContext) appContext).close();
		}

		return lista;
	}

	private Integer validateUser(Usuario usuario) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/onlinedonation/xml/beans.xml");
		Integer id = null;
		try {
			SIUsuario siUsuario = (SIUsuario) appContext.getBean(ServiceUsuarioImp.class);
			id = siUsuario.checkUsuario(usuario);

		} catch (NoSuchBeanDefinitionException e) {
			System.err.println("Bean no encontrado :" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Otro error " + e.getMessage());
		} finally {
			((ConfigurableApplicationContext) appContext).close();
		}

		return id;
	}

}
