package ua.nure.ivannikova.dao;

import java.util.List;

import ua.nure.ivannikova.dto.RealtyDTO;
import ua.nure.ivannikova.dto.SearchDTO;

public interface RealtyDAO {

	List<RealtyDTO> searchRealties(SearchDTO searchDTO);

}