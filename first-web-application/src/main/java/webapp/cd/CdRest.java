package webapp.cd;

import javax.ws.rs.Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.bson.json.JsonWriter;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;



@Path("/restCd.do")
public class CdRest {
	
	CdService cdService = new CdService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
    public String hello(@DefaultValue("Britney Spears") @QueryParam("Cd") String name) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("local");
    	DBCollection cdsCollection = db.getCollection("cds");
    	DBCursor cursor = cdsCollection.find();
    	JSON json = new JSON();
    	String serialize = json.serialize(cursor);
    	
    	List<String>cdList = new ArrayList<String>();
    	for (String item: serialize.split(",")) {
    		if (!item.contains("id")&&!item.contains("amount")) {
                cdList.add(item);
    		}
         }
    	
    	String cds = String.join(System.lineSeparator(), cdList);
    	
    	return cds;
    }
    
}