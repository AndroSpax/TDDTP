/**
 * 
 */
package com.store.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.store.persistence.IArticlePersistence;

/**
 * @author Mariell Macheal Rudolph
 *
 */

public class ArticleController {

	
	@Autowired
	IArticlePersistence articlePersistence;
}
