package com.blumonpay.BlumonPayTest.services;

import java.util.List;

import com.blumonpay.BlumonPayTest.daos.IGenericDao;
import com.blumonpay.BlumonPayTest.exceptions.NoInformationFoundException;


public abstract class IGenericCrud<T, ID> {

	protected abstract IGenericDao<T, ID> getRepo();
	protected abstract void validateEntityToSave(T t);
	protected abstract void validateEntityToUpdate(T t);
	
	
	public List<T> list(){
		List<T> response = getRepo().findAll();
		if(response.isEmpty()) throw new NoInformationFoundException("There ain't elements");
		return getRepo().findAll();
	}
	
	public T findById(ID id) {
		return getRepo().findById(id).orElseThrow(() -> new NoInformationFoundException("The elements with id " + id + " has not been found"));
	}
	
	public T save(T t) {
		validateEntityToSave(t);
		return getRepo().save(t);
	}
	
	public T update(T t, ID id) {
		validateEntityToUpdate(t);
		findById(id);
		return getRepo().save(t);
	}
	
	public T delete(ID id) {
		T t =  findById(id);
		getRepo().deleteById(id);
		return t;
	}
	
}
