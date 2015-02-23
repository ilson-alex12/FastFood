package danielm59.fastfood.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import danielm59.fastfood.block.*;
import danielm59.fastfood.block.crops.*;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModBlocks {

	public static final BlockFF counter = 	new BlockCounter();
	public static final BlockFF grinder = 	new BlockGrinder();
	public static final BlockFF churn =		new BlockChurn();
	public static final BlockFF press = 	new BlockPress();
	
	public static void init(){
		
		GameRegistry.registerBlock(counter, 	"counter");
		GameRegistry.registerBlock(grinder, 	"grinder");
		GameRegistry.registerBlock(churn, 		"churn");
		GameRegistry.registerBlock(press, 		"press");
	
	}
	
	@SideOnly(Side.CLIENT)
	public static void textures(){
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(counter), 	0, new ModelResourceLocation("fastfood:counter", 	"inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(grinder), 	0, new ModelResourceLocation("fastfood:grinder",	"inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(churn),	0, new ModelResourceLocation("fastfood:churn", 		"inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(press), 	0, new ModelResourceLocation("fastfood:press", 		"inventory"));
		
	}
	
}
