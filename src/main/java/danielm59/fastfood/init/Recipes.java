package danielm59.fastfood.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.knife, "i ", " s", 'i', "ingotIron", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.counter, "sss", "pcp", "ppp", 'p', "plankWood", 's', Blocks.stone_slab, 'c', Blocks.chest));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModFood.rawbacon, 3), "k", "p", 'k', new ItemStack(ModItems.knife, 1, OreDictionary.WILDCARD_VALUE), 'p', Items.porkchop));
		
		GameRegistry.addSmelting(ModFood.rawbacon, new ItemStack(ModFood.bacon), 0.1F);
		
	}
	
}
