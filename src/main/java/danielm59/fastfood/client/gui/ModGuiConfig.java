package danielm59.fastfood.client.gui;

import danielm59.fastfood.handler.ConfigurationHandler;
import danielm59.fastfood.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ModGuiConfig extends GuiConfig{

	public ModGuiConfig(GuiScreen guiScreen)
	     {
	         
		super(guiScreen,
	                 new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
	                 Reference.MODID,
	                 false,
	                 false,
	                 GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
	
	     }
	
}
