package org.monsite.servletbeer.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document; // il faut l'importer
import org.monsite.servletbeer.modele.Beer;

import com.mongodb.MongoClient;  // il faut l'importer
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


public class BeerMongoDAO {

		private MongoClient client;
		private MongoDatabase database;
		private MongoCollection<Document> collection;
		
		private BeerMongoDAO(){
			this.client = new MongoClient("localhost");
			this.database = this.client.getDatabase("beers");
			this.collection = this.database.getCollection("beers");
		}
		
		private static BeerMongoDAO beerMongoDAO;
		
		public static BeerMongoDAO getBeerMongoDAOInstance(){
			
			if (null == beerMongoDAO){
				beerMongoDAO = new BeerMongoDAO();
			}
			return beerMongoDAO;
		}
		
		public Beer getBeer(String beerId) {
			
			// recherche biere pr id
			Document doc = collection.find(Filters.eq("id", beerId)).first();
			Beer beer = new Beer();
			beer.setId(doc.getString("id"));
			beer.setDescription(doc.getString("description"));
			beer.setImg(doc.getString("img"));
			beer.setName(doc.getString("name"));
			
			Object alcohol = doc.get("alcohol"); // car valeurs peuvent �tre enti�re ou double et ca pose pb
			
			if (alcohol instanceof Double){
				beer.setAlcohol( (Double) alcohol);
			} else {
				
				beer.setAlcohol( (int) alcohol); // conversion n�c�ssaire
				
			}
			
			beer.setAvailability(doc.getString("availability"));
			beer.setLabel(doc.getString("label"));
			beer.setBrewery(doc.getString("brewery"));
			beer.setStyle(doc.getString("style"));
			beer.setServing(doc.getString("serving"));
			
			return beer;
		}
		
		public List<Beer> getBeerList() {
			List<Beer> beers = new ArrayList<Beer>();
			MongoCursor<Document> cursor = this.collection.find().iterator();
			
			while (cursor.hasNext()){
				Document doc = cursor.next();
				Beer beer = new Beer();
				beer.setId(doc.getString("id"));
				beer.setDescription(doc.getString("description"));
				beer.setImg(doc.getString("img"));
				beer.setName(doc.getString("name"));
				Object alcohol = doc.get("alcohol");
				
				if (alcohol instanceof Double){
					beer.setAlcohol( (Double) alcohol);
				} else {
					
					beer.setAlcohol( (int) alcohol); // conversion n�c�ssaire
					
				}
				
				beers.add(beer);		
			}
			
			return beers;
		}
}
