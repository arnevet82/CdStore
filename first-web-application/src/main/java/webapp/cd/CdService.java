package webapp.cd;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import webapp.client.ClientService;

public class CdService {
	
	MongoClient mongoClient = new MongoClient("localhost", 27017);
	DB db = mongoClient.getDB("local");
	DBCollection cdsCollection = db.getCollection("cds");
	DBCollection soldCollection = db.getCollection("sold_cds");
	
	MongoDatabase database = mongoClient.getDatabase("local");
	MongoCollection<Document> col = database.getCollection("cds");
//	ClientService clientService = new ClientService();
	
	static List<Cd>currentlyBought = new ArrayList<Cd>();
	static {
	}
	
	
	public List<DBObject> retrieveCds(){
		
		List<DBObject> all = cdsCollection.find().toArray();
		return all;
	}
	
	public List<DBObject> retrieveSoldCds(){
		
		List<DBObject> allSold = soldCollection.find().toArray();
		return allSold;
	}
	
	public List<Cd> retrieveCurrentlyBoughtCds(){
		
		return currentlyBought;
	}
	
	public DBObject retrieveOneCd(int id){
		
		DBObject query = new BasicDBObject("id", id);
		DBCursor cursor = cdsCollection.find(query);
		DBObject obj = null;
		if( cursor.hasNext() ) {
			obj = cursor.next();
		}
		
		return obj;

	}
	
	public DBObject retrieveSoldCd(int id){
		
		DBObject query = new BasicDBObject("id", id);
		DBCursor cursor = soldCollection.find(query);
		DBObject obj = null;
		if( cursor.hasNext() ) {
			obj = cursor.next();
		}
		
		return obj;

	}
	
	public void addCd(Cd cd) throws IOException {
		
		BasicDBObject cdObj = new BasicDBObject();
		cdObj.put("name", cd.getName());
		cdObj.put("price", cd.getPrice());
		cdObj.put("amount", cd.getAmount());
		cdObj.put("id", cd.getId());
		cdsCollection.insert(cdObj);
	}
	
	public void deleteCd(Cd cd) {
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("id", cd.getId());

		cdsCollection.remove(searchQuery);
	}
	
	public void buyCd(int id) {
		
		BasicDBObject searchQuery = new BasicDBObject();
		DBObject currentCd = this.retrieveOneCd(id);
		
		searchQuery.put("id", id);
		searchQuery.put("name", currentCd.get("name"));
		searchQuery.put("price", currentCd.get("price"));
		String name = (String) currentCd.get("name");
		double price = (double) currentCd.get("price");
		currentlyBought.add(new Cd(name, price, 0, 0));
		int currentAmount = (int) currentCd.get("amount") - 1;
		
		if(currentAmount > 0) {
			col.updateOne(new Document("id", id),  
	                new Document("$set", new Document("amount", currentAmount)));
		}else {
			cdsCollection.remove(searchQuery);
		}
		
		soldCollection.insert(searchQuery);
	}
}
