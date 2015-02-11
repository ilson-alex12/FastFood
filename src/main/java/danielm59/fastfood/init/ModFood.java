package danielm59.fastfood.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import danielm59.fastfood.item.FoodFF;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModFood {

	public static final FoodFF roll = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("roll");
	public static final FoodFF rawbacon = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("rawbacon");
	public static final FoodFF bacon = (FoodFF) new FoodFF(2, 0.2F, false).setUnlocalizedName("bacon");
	public static final FoodFF baconroll = (FoodFF) new FoodFF(3, 0.3F, false).setUnlocalizedName("baconroll");
	public static final FoodFF rawmince = (FoodFF) new FoodFF(3, 0.3F, false).setUnlocalizedName("rawmince");
	public static final FoodFF rawbeefpatty = (FoodFF) new FoodFF(3, 0.3F, false).setUnlocalizedName("rawbeefpatty");
	public static final FoodFF beefpatty = (FoodFF) new FoodFF(8, 0.8F, false).setUnlocalizedName("beefpatty");
	public static final FoodFF beefburger = (FoodFF) new FoodFF(9, 0.9F, false).setUnlocalizedName("beefburger");
	public static final FoodFF tomato = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("tomato");
	public static final FoodFF butter = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("butter");
	public static final FoodFF cheese = (FoodFF) new FoodFF(2, 0.2F, false).setUnlocalizedName("cheese");
	public static final FoodFF gratedcheese = (FoodFF) new FoodFF(2, 0.2F, false).setUnlocalizedName("gratedcheese");
	
	public static void init(){
		
		GameRegistry.registerItem(roll, "roll");
		GameRegistry.registerItem(rawbacon, "rawbacon");
		GameRegistry.registerItem(bacon, "bacon");
		GameRegistry.registerItem(baconroll, "baconroll");
		GameRegistry.registerItem(rawmince, "rawmince");
		GameRegistry.registerItem(rawbeefpatty, "rawbeefpatty");
		GameRegistry.registerItem(beefpatty, "beefpatty");
		GameRegistry.registerItem(beefburger, "beefburger");
		GameRegistry.registerItem(tomato, "tomato");
		GameRegistry.registerItem(butter, "butter");
		GameRegistry.registerItem(cheese, "cheese");
		GameRegistry.registerItem(gratedcheese, "gratedcheese");
		
	}
	
	public static void textures(){
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(roll, 0, new ModelResourceLocation("fastfood:roll", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(rawbacon, 0, new ModelResourceLocation("fastfood:rawbacon", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(bacon, 0, new ModelResourceLocation("fastfood:bacon", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(baconroll, 0, new ModelResourceLocation("fastfood:baconroll", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(rawmince, 0, new ModelResourceLocation("fastfood:rawmince", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(rawbeefpatty, 0, new ModelResourceLocation("fastfood:rawbeefpatty", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(beefpatty, 0, new ModelResourceLocation("fastfood:beefpatty", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(beefburger, 0, new ModelResourceLocation("fastfood:beefburger", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tomato, 0, new ModelResourceLocation("fastfood:tomato", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(butter, 0, new ModelResourceLocation("fastfood:butter", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(cheese, 0, new ModelResourceLocation("fastfood:cheese", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(gratedcheese, 0, new ModelResourceLocation("fastfood:gratedcheese", "inventory"));
	
	}
	
}
