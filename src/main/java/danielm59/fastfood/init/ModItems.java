package danielm59.fastfood.init;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danielm59.fastfood.item.ItemFF;
import danielm59.fastfood.item.ItemGrater;
import danielm59.fastfood.item.ItemKnife;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModItems {

	public static final ItemFF knife = 					new ItemKnife();
	public static final ItemFF grater = 				new ItemGrater();
	public static final ItemFF flourbag = 	(ItemFF) 	new ItemFF().setUnlocalizedName("flourbag");
	public static final ItemFF wheatflour = (ItemFF) 	new ItemFF().setUnlocalizedName("wheatflour");
	public static final ItemFF millstone = 	(ItemFF)	new ItemFF().setUnlocalizedName("millstone");
	
	public static void init(){
		
		GameRegistry.registerItem(knife, 		"knife");
		GameRegistry.registerItem(grater, 		"grater");
		GameRegistry.registerItem(flourbag, 	"flourbag");
		GameRegistry.registerItem(wheatflour, 	"wheatflour");
		GameRegistry.registerItem(millstone, 	"millstone");
		
	}
	
}
