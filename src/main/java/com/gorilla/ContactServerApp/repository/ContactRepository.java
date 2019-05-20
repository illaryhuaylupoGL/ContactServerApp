/**
 * 
 */
package com.gorilla.ContactServerApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gorilla.ContactServerApp.entity.ContactEntity;

/**
 * Contact Repository
 * @author ihuaylupo
 *
 */

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, String> {

}
