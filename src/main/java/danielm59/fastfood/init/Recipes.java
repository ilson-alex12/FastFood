package danielm59.fastfood.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.knife, "i ", " s", 'i', "ingotIron", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.counter, "sss", "pcp", "ppp", 'p', "plankWood", 's', "cobblestone", 'c', Blocks.chest));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModFood.rawbacon, 3), "k", "p", 'k', ModItems.knife, 'p', Items.porkchop));
	
	}
	
}
