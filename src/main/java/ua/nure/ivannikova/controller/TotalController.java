package ua.nure.ivannikova.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ua.nure.ivannikova.dto.RealtyDTO;
import ua.nure.ivannikova.dto.SearchDTO;
import ua.nure.ivannikova.dto.ViewingDTO;
import ua.nure.ivannikova.entity.Owner;
import ua.nure.ivannikova.service.OwnerService;
import ua.nure.ivannikova.service.RealtyService;
import ua.nure.ivannikova.service.ViewingService;
import ua.nure.ivannikova.util.Validation;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TotalController {

	private static final Logger logger = LoggerFactory.getLogger(TotalController.class);

	@Autowired
	private OwnerService ownerService;

	@Autowired
	private ViewingService viewingService;

	@Autowired
	private RealtyService realtyService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(@ModelAttribute Owner owner) {
		return new ModelAndView("home", "owner", owner);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String viewing(@Valid @ModelAttribute SearchDTO searchDTO, BindingResult bindingResult) {
		return "search";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@ModelAttribute Owner owner, HttpSession session) {

		if (session != null) {
			session.invalidate();
		}
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkUser(@Valid @ModelAttribute Owner owner, BindingResult bindingResult,
			HttpSession session) {

		if (session.getAttribute("user") == null) {
			String login = owner.getLogin() == null ? owner.getEmail() : owner.getLogin();
			if (bindingResult.hasErrors() || (owner = ownerService.authOwner(login, owner.getPassword())) == null) {
				return new ModelAndView("home", "message", "Incorrect credentials.");
			}
		}
		session.setAttribute("user", owner);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public ModelAndView success(@Valid @ModelAttribute ViewingDTO viewing, BindingResult bindingResult,
			@RequestParam("datetime") String date, @RequestParam("time") String time, @RequestParam("id") String id) {
		viewing.setId(Long.valueOf(id));
		if (!viewingService.createViewing(viewing, date, time) || !Validation.dateValidation(date)
				|| !Validation.timeValidation(time)) {
			ModelAndView modelAndView = new ModelAndView("viewing");
			modelAndView.addObject("viewing", viewing);
			modelAndView.addObject("message", "Choose another date or time for review.");
			return modelAndView;
		}
		return new ModelAndView("success", "message", "Your request was successfully sent.");
	}

	@RequestMapping(value = "/sign-for-review", method = RequestMethod.GET)
	public ModelAndView signForReview(@ModelAttribute ViewingDTO viewing) {
		return new ModelAndView("viewing", "viewing", viewing);
	}

	@RequestMapping(value = "/execute-search", method = RequestMethod.POST)
	@ResponseBody
	public List<RealtyDTO> search(@Valid @ModelAttribute SearchDTO searchDTO, BindingResult bindingResult) {
		List<RealtyDTO> list = realtyService.searchRealties(searchDTO);
		return list;
	}

	@RequestMapping(value = "/get-reviews-by-date", method = RequestMethod.POST)
	@ResponseBody
	public List<ViewingDTO> getReviewsByDate(@RequestParam("datetime") String date, HttpSession session) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = df.parse(date);
		} catch (ParseException e) {
			logger.error(e.getLocalizedMessage());
		}

		List<ViewingDTO> list = viewingService.getViewingsForOwnerByDate(d, (Owner) session.getAttribute("user"));
		return list;
	}
}
