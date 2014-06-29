package danielm59.fastfood.configuration;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

	public static void init(File configFile){
		
		Configuration configuration = new Configuration(configFile);
		
		try{
			
			configuration.load();
			
			//TODO Read configuration file
		
		}
		catch(Exception e){
			
			//TODO log the exception
			
		}
		finally{
			
			configuration.save();
			
		}
		
	}
	
}
