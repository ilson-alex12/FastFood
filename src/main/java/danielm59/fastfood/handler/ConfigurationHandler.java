package danielm59.fastfood.handler;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import danielm59.fastfood.reference.Reference;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

	public static Configuration configuration;
	
	public static void init(File configFile){
		
		if (configuration == null){
		
			Configuration configuration = new Configuration(configFile);
		
		}
		
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
		
		if (event.modID.equalsIgnoreCase(Reference.MODID)){
			
			loadConfiguration();
			
		}
		
	}
	
	public void loadConfiguration(){
	
		//Load config values
		
		if(configuration.hasChanged()){
			
			configuration.save();
			
		}
		
	}
	
}
