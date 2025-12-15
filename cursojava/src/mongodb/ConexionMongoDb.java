package mongodb;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.ListCollectionNamesIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionMongoDb {

	public static void main(String[] args) {
		String connectionString = "mongodb+srv://usuariocurso:Xt3l9yqd2gLYWrgq@cluster0.evyfvcr.mongodb.net/?appName=Cluster0";
		ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
		MongoClientSettings settings = MongoClientSettings.builder()
				.applyConnectionString(new ConnectionString(connectionString)).serverApi(serverApi).build();
		// Crea un nuevo cliente y conecta al servidor
		try (MongoClient mongoClient = MongoClients.create(settings)) {
			System.out.println("Conexión exitosa a MongoDB!");			
			try {
				// Envía un ping para confirmar una conexión exitosa
				MongoDatabase database = mongoClient.getDatabase("getafemongodb");
				ListCollectionNamesIterable listCollections = database.listCollectionNames();
				
				for (String string : listCollections) {
					System.out.println("Colección: " + string);
				}
				
				Document doc1 = new Document();
				doc1.append("nombre", "Ana");
				doc1.append("edad", 28);
				
				database.getCollection("usuarios").insertOne(doc1);
				
				
				
			} catch (MongoException e) {
				e.printStackTrace();
			}
		}
	}
}