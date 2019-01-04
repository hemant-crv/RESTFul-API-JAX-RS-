package org.javabrains.messenger.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.javabrains.messenger.database.DatabaseClass;
import org.javabrains.messenger.model.Profile;

public class ProfileService {

private Map<String, Profile> profiles = DatabaseClass.getProfile();
	
	public ProfileService()
	{
	  profiles.put("hemant", new Profile(1L,"hemant","Hemant","Choudhary"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList <Profile>(profiles.values());
	}
	
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfiles(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty())
		{
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
    public Profile removeProfile(String profileName) {
    	return profiles.remove(profileName);
    }
}
