package ua.nure.ivannikova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.nure.ivannikova.dao.OwnerDAOImpl;
import ua.nure.ivannikova.entity.Owner;

@Service
public class OwnerService {

	@Autowired
	private OwnerDAOImpl ownerDAO;

	public Owner authOwner(String login, String password) {
		return ownerDAO.getOwnerByCredentials(login, password);
	}

}
