package danielm59.fastfood.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import danielm59.fastfood.handler.ConfigurationHandler;
import danielm59.fastfood.reference.Reference;

public class ModGuiConfig extends GuiConfig {
    
    public ModGuiConfig(GuiScreen guiScreen) {
    
        super(guiScreen, new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MODID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
        
    }
    
}
