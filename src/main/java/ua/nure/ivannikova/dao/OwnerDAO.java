package ua.nure.ivannikova.dao;

import ua.nure.ivannikova.entity.Owner;

public interface OwnerDAO {

	Owner getOwnerByCredentials(String login, String password);

}