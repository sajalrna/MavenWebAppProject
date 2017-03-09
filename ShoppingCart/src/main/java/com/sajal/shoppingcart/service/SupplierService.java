package com.sajal.shoppingcart.service;

import java.util.List;

import com.sajal.shoppingcart.model.Supplier;

public interface SupplierService {

	public List<Supplier> supplier(); // get all suppliers

	public boolean save(Supplier supplier); // create supplier

	public boolean update(Supplier supplier); // update supplier

	public boolean delete(String id); // delete supplier by id

	public boolean delete(Supplier supplier);// delete supplier by supplier

	public Supplier getSupplierByID(String id); // get() supplier by id

	public Supplier getSupplierByName(String name); // get() supplier by name
}