package endpoints;



import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@Api(name = "myApi",
version = "v1",
audiences =  "11539977313-dprg4bih20b3crq6a5f94cap1ckul4pq.apps.googleusercontent.com",
clientIds = "11539977313-dprg4bih20b3crq6a5f94cap1ckul4pq.apps.googleusercontent.com",
namespace = @ApiNamespace(ownerDomain = "helloworld.example.com",

    ownerName = "helloworld.example.com",
    packagePath = ""))

public class PetitionEndpoint {
		
	@ApiMethod(name = "addPetition", httpMethod = ApiMethod.HttpMethod.GET)
	public Entity addPetition(@Named("mailAuteurPetition") String mailAuteurPetition, @Named("titrePetition") String titrePetition, @Named("descriptionPetition") String descriptionPetition) {
			Entity petition = new Entity("Petition", "P"+titrePetition);
			petition.setProperty("mailAuteurPetition", mailAuteurPetition);
			petition.setProperty("titrePetition", titrePetition);
			petition.setProperty("descriptionPetition", descriptionPetition);
			petition.setProperty("nbSignature", 0);
			petition.setProperty("dateCreation",System.currentTimeMillis());
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
			datastore.put(petition);
			return  petition;
	}

	
	
	
}