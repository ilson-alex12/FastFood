package danielm59.fastfood.init;

import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.item.*;

public class ModItems {

	public static final ItemFF knife = new ItemKnife();
	
	public static void init(){
		
		GameRegistry.registerItem(knife, "knife");
		
	}
	
}
