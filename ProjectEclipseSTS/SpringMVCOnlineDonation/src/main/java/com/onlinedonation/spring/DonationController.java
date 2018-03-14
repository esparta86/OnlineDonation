package com.onlinedonation.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.onlinedonation.bean.Donation;
import com.onlinedonation.bean.Institution;
import com.onlinedonation.service.SIDonation;
import com.onlinedonation.service.SIInstitution;
import com.onlinedonation.service.ServiceDonationImp;
import com.onlinedonation.service.ServiceInstitutionImp;
import com.onlinedonation.util.finalConstantParameter;
import com.onlinedonation.validator.DonationValidator;

@Controller
public class DonationController {

	private DonationValidator donationValidator;

	public DonationController() {
		this.donationValidator = new DonationValidator();
	}

	@RequestMapping(value = "irDonationView", method = RequestMethod.GET)
	public ModelAndView cargarPortalInicial() {
		ModelAndView mac = new ModelAndView();
		mac.setViewName("donationView");
		mac.addObject("msjBienvenida", finalConstantParameter.STRING_MSJ_BIENVENIDA);
		mac.addObject("cmdDonation", new Donation());

		return mac;
	}

	@ModelAttribute("institutionList")
	private Map<String, String> retrieveAllInstitution() {
		Map<String, String> listInstitution = new LinkedHashMap<>();
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/onlinedonation/xml/beans.xml");
		List<Institution> lista = new ArrayList<>();
		try {
			SIInstitution siInstitution = (SIInstitution) appContext.getBean(ServiceInstitutionImp.class);
			lista = siInstitution.retrieveAllInstitution();
			for (Institution ins : lista) {
				listInstitution.put(ins.getIdInstitution().toString(), ins.getNameIntitution());
			}

		} catch (NoSuchBeanDefinitionException e) {
			System.err.println("Bean not found :" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("another error " + e.getMessage());
		} finally {
			((ConfigurableApplicationContext) appContext).close();
		}

		return listInstitution;

	}

	@RequestMapping(value = "/addDonation", method = RequestMethod.POST)
	public ModelAndView formDonation(@ModelAttribute("cmdDonation") Donation donation, BindingResult result,
			SessionStatus status) {
		this.donationValidator.validate(donation, result);
		ModelAndView amv = new ModelAndView();
		if (result.hasErrors()) {
			amv.setViewName("donationView");
			amv.addObject("cmdDonation", donation);
		} else {
			try {
				amv.setViewName("donationView");
				amv.addObject("msjResult", "donation saved ");
				registerDonation(donation);
			} catch (Exception e) {
				e.printStackTrace();
				amv.addObject("msjResult", "donation not saved ");
			}
		}
		return amv;
	}

	private void registerDonation(Donation donation) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/onlinedonation/xml/beans.xml");

		try {
			SIDonation siDonation = (SIDonation) appContext.getBean(ServiceDonationImp.class);

			donation.setIdUsuario(new Integer(1));
			donation.setDonationDate(new Date());

			siDonation.registerDonation(donation);

		} catch (NoSuchBeanDefinitionException e) {
			System.err.println("Bean no encontrado :" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Otro error " + e.getMessage());
		} finally {
			((ConfigurableApplicationContext) appContext).close();
		}
	}

}
