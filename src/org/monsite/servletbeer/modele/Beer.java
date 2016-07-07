package org.monsite.servletbeer.modele;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.monsite.servletbeer.dao.BeerMongoDAO;


public class Beer {
	private double alcohol ;
	private String availability ;
	private String brewery ;
	private String description ;
	private String id ;
	private String img ;
	private String label ;
	private String name ;
	private String serving ;
	private String style ;
	
	public double getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getBrewery() {
		return brewery;
	}
	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.id = StringUtils.capitalize( StringUtils.stripAccents( StringUtils.remove( this.name, " ") ) );
	}
	public String getServing() {
		return serving;
	}
	public void setServing(String serving) {
		this.serving = serving;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	
	public static List<Beer> getBeers() {
	     
	       return BeerMongoDAO.getBeerMongoDAOInstance().getBeerList();
	   }


}
