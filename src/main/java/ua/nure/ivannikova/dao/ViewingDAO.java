package ua.nure.ivannikova.dao;

import java.util.Date;
import java.util.List;

import ua.nure.ivannikova.dto.ViewingDTO;
import ua.nure.ivannikova.entity.Owner;

public interface ViewingDAO {

	List<ViewingDTO> getViewingsByDateAndOwnerId(Date date, Owner owner);

	boolean createViewing(ViewingDTO viewingDTO, String date, String time);

}