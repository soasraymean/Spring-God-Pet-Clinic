package com.tyjohntompson.springgodpetclinic.service;

import com.tyjohntompson.springgodpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
