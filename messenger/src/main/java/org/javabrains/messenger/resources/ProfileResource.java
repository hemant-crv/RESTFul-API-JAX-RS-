package org.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.javabrains.messenger.model.Profile;
import org.javabrains.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {

	ProfileService ProfileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		return ProfileService.getAllProfiles();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile Profile) {
	  return ProfileService.addProfiles(Profile);	
	}
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return ProfileService.updateProfile(profile);
		
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profileName") String profileName) {
		ProfileService.removeProfile(profileName);	
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName") String profileName) {
	return ProfileService.getProfile(profileName);
	}
}
