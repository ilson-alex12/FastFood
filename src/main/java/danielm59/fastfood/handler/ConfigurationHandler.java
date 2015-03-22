package danielm59.fastfood.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import danielm59.fastfood.reference.Reference;

public class ConfigurationHandler {
    
    public static Configuration configuration;
    
    public static void init(File configFile) {
    
        if (configuration == null) {
            
            configuration = new Configuration(configFile);
            loadConfiguration();
            
        }
        
    }
    
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
    
        if (event.modID.equalsIgnoreCase(Reference.MODID)) {
            
            loadConfiguration();
            
        }
        
    }
    
    private static void loadConfiguration() {
    
        // load config values
        
        if (configuration.hasChanged()) {
            
            configuration.save();
            
        }
        
    }
    
}
