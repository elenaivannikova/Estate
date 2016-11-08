package ua.nure.ivannikova.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.nure.ivannikova.dao.ViewingDAOImpl;
import ua.nure.ivannikova.dto.ViewingDTO;
import ua.nure.ivannikova.entity.Owner;

@Service
public class ViewingService {

	@Autowired
	private ViewingDAOImpl viewingDAO;

	public List<ViewingDTO> getViewingsForOwnerByDate(Date date, Owner owner) {
		return viewingDAO.getViewingsByDateAndOwnerId(date, owner);
	}

	public boolean createViewing(ViewingDTO viewingDTO, String date, String time) {
		return viewingDAO.createViewing(viewingDTO, date, time);
	}

}
