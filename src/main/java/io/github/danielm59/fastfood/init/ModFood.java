package io.github.danielm59.fastfood.init;

import io.github.danielm59.fastfood.item.FoodDrinkableFF;
import io.github.danielm59.fastfood.item.FoodFF;
import io.github.danielm59.fastfood.reference.Reference;
import io.github.danielm59.fastfood.utility.TextureHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModFood
{
    
    public static final FoodFF breaddough     = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("breaddough");
    public static final FoodFF pizzabase      = (FoodFF) new FoodFF(3, 0.3F, false).setUnlocalizedName("pizzabase");
    public static final FoodFF rawpizza       = (FoodFF) new FoodFF(5, 0.6F, false).setUnlocalizedName("rawpizza");
    public static final FoodFF pizza          = (FoodFF) new FoodFF(8, 0.8F, false).setUnlocalizedName("pizza");
    public static final FoodFF rawbread       = (FoodFF) new FoodFF(2, 0.1F, false).setUnlocalizedName("rawbread");
    public static final FoodFF roll           = (FoodFF) new FoodFF(2, 0.3F, false).setUnlocalizedName("roll");
    public static final FoodFF rawbacon       = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("rawbacon");
    public static final FoodFF bacon          = (FoodFF) new FoodFF(3, 0.6F, false).setUnlocalizedName("bacon");
    public static final FoodFF baconroll      = (FoodFF) new FoodFF(5, 0.6F, false).setUnlocalizedName("baconroll");
    public static final FoodFF rawmince       = (FoodFF) new FoodFF(2, 0.3F, false).setUnlocalizedName("rawmince");
    public static final FoodFF rawbeefpatty   = (FoodFF) new FoodFF(2, 0.3F, false).setUnlocalizedName("rawbeefpatty");
    public static final FoodFF beefpatty      = (FoodFF) new FoodFF(6, 0.6F, false).setUnlocalizedName("beefpatty");
    public static final FoodFF beefburger     = (FoodFF) new FoodFF(10, 0.6F, false).setUnlocalizedName("beefburger");
    public static final FoodFF tomato         = (FoodFF) new FoodFF(1, 0.3F, false).setUnlocalizedName("tomato");
    public static final FoodFF butter         = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("butter");
    public static final FoodFF cheese         = (FoodFF) new FoodFF(2, 0.1F, false).setUnlocalizedName("cheese");
    public static final FoodFF gratedcheese   = (FoodFF) new FoodFF(2, 0.1F, false).setUnlocalizedName("gratedcheese");
    public static final FoodFF sunflowerseeds = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("sunflowerseeds");
    public static final FoodFF rawfries       = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("rawfries");
    public static final FoodFF fries          = (FoodFF) new FoodFF(3, 0.6F, false).setUnlocalizedName("fries");
    public static final FoodFF tomatosauce    = (FoodFF) new FoodDrinkableFF(2, 0.3F, false).setUnlocalizedName("tomatosauce").setContainerItem(Items.glass_bottle);
                                              
    public static void init()
    {
        
        GameRegistry.registerItem(breaddough, "breaddough");
        GameRegistry.registerItem(pizzabase, "pizzabase");
        GameRegistry.registerItem(rawpizza, "rawpizza");
        GameRegistry.registerItem(pizza, "pizza");
        GameRegistry.registerItem(rawbread, "rawbread");
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
        GameRegistry.registerItem(sunflowerseeds, "sunflowerseeds");
        GameRegistry.registerItem(tomatosauce, "tomatosauce");
        GameRegistry.registerItem(rawfries, "rawfries");
        GameRegistry.registerItem(fries, "fries");
        
        MinecraftForge.addGrassSeed(new ItemStack(sunflowerseeds), 10);
        
    }
    
    @SideOnly(Side.CLIENT)
    public static void textures()
    {
        
        TextureHelper.register(breaddough);
        TextureHelper.register(pizzabase);
        TextureHelper.register(rawpizza);
        TextureHelper.register(pizza);
        TextureHelper.register(rawbread);
        TextureHelper.register(roll);
        TextureHelper.register(rawbacon);
        TextureHelper.register(bacon);
        TextureHelper.register(baconroll);
        TextureHelper.register(rawmince);
        TextureHelper.register(rawbeefpatty);
        TextureHelper.register(beefpatty);
        TextureHelper.register(beefburger);
        TextureHelper.register(tomato);
        TextureHelper.register(butter);
        TextureHelper.register(cheese);
        TextureHelper.register(gratedcheese);
        TextureHelper.register(sunflowerseeds);
        TextureHelper.register(tomatosauce);
        TextureHelper.register(rawfries);
        TextureHelper.register(fries);
        
    }
    
}
