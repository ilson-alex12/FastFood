package danielm59.fastfood.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import danielm59.fastfood.item.*;
import danielm59.fastfood.item.seed.*;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModItems {

	public static final ItemFF knife = new ItemKnife();
	public static final ItemFF grater = new ItemGrater();
	
	public static void init(){
		
		GameRegistry.registerItem(knife, "knife");
		GameRegistry.registerItem(grater, "grater");
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void textures(){
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(knife, 0, new ModelResourceLocation("fastfood:knife", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(grater, 0, new ModelResourceLocation("fastfood:grater", "inventory"));
		
	}
	
}
