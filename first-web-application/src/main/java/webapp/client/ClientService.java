package webapp.client;

import java.io.IOException;
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
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import webapp.cd.Cd;
import webapp.cd.CdService;

public class ClientService {
	
	MongoClient mongoClient = new MongoClient("localhost", 27017);
	
	DB db = mongoClient.getDB("local");
	DBCollection clientsCollection = db.getCollection("clients");
	
	MongoDatabase database = mongoClient.getDatabase("local");
    MongoCollection<Document> col = database.getCollection("clients");
    
    private CdService cdService = new CdService();
    
	
	public List<DBObject> retrieveClients(){
		
		List<DBObject> all = clientsCollection.find().toArray();
		
		return all;
	}
	
	public DBObject retrieveOneClient(String email){
		
		DBObject query = new BasicDBObject("email", email);
		DBCursor cursor = clientsCollection.find(query);
		DBObject obj = null;
		if( cursor.hasNext() ) {
			obj = cursor.next();
		}
		
		return obj;

	}
	
	public void addClient(Client client) throws IOException {
		
		BasicDBObject clientObj = new BasicDBObject();
		clientObj.put("firstName", client.getFirstName());
		clientObj.put("lastName", client.getLastName());
		clientObj.put("email", client.getEmail());
		clientObj.put("password", client.getPassword());
		clientObj.put("cds", new ArrayList<String>());


		clientsCollection.insert(clientObj);
	}
	
	public void addCdToClient(Client client, int id) throws IOException {
		DBObject cdObj = cdService.retrieveSoldCd(id);
	
        col.updateOne(new Document("email", client.getEmail()),  
                new Document("$addToSet", new Document("cds", cdObj)));

	}
	
}
