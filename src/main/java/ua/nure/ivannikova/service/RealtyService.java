package ua.nure.ivannikova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.nure.ivannikova.dao.RealtyDAOImpl;
import ua.nure.ivannikova.dto.RealtyDTO;
import ua.nure.ivannikova.dto.SearchDTO;

@Service
public class RealtyService {

	@Autowired
	private RealtyDAOImpl realtyDAO;

	public List<RealtyDTO> searchRealties(SearchDTO searchDTO) {
		return realtyDAO.searchRealties(searchDTO);
	}

}
