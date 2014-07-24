package danielm59.fastfood.init;

import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.knife, "i ", " s", 'i', "ingotIron", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.counter, "sss", "pcp", "ppp", 'p', "plankWood", 's', "cobblestone", 'c', Blocks.chest));
	
	}
	
}
