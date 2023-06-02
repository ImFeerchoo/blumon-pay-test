package com.blumonpay.BlumonPayTest.services;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T, ID> {
	List<T> list();
	T findById(ID id);
	T update(T t, ID id);
	T save(T t);
	T delete(ID id);
}
