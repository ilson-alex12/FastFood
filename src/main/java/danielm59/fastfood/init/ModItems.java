package danielm59.fastfood.init;

import danielm59.fastfood.item.ItemBlockFF;
import danielm59.fastfood.item.ItemFF;
import danielm59.fastfood.item.ItemGrater;
import danielm59.fastfood.item.ItemKnife;
import danielm59.fastfood.reference.Reference;
import danielm59.fastfood.utility.TextureHelper;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModItems
{
    
    public static final ItemFF knife      = new ItemKnife();
    public static final ItemFF grater     = new ItemGrater();
    public static final ItemFF flourbag   = (ItemFF) new ItemFF().setUnlocalizedName("flourbag");
    public static final ItemFF wheatflour = (ItemFF) new ItemFF().setUnlocalizedName("wheatflour");
    public static final ItemFF millstone  = (ItemFF) new ItemFF().setUnlocalizedName("millstone");
    public static final ItemFF fryer      = (ItemFF) new ItemBlockFF(ModBlocks.fryer).setUnlocalizedName("fryer");
    public static final ItemFF cookingoil = (ItemFF) new ItemFF().setUnlocalizedName("cookingoil").setContainerItem(Items.glass_bottle);
                                          
    public static void init()
    {
        
        GameRegistry.registerItem(knife, "knife");
        GameRegistry.registerItem(grater, "grater");
        GameRegistry.registerItem(flourbag, "flourbag");
        GameRegistry.registerItem(wheatflour, "wheatflour");
        GameRegistry.registerItem(millstone, "millstone");
        GameRegistry.registerItem(fryer, "fryer");
        GameRegistry.registerItem(cookingoil, "cookingoil");
        
    }
    
    @SideOnly(Side.CLIENT)
    public static void textures()
    {
        
        TextureHelper.register(knife);
        TextureHelper.register(grater);
        TextureHelper.register(flourbag);
        TextureHelper.register(wheatflour);
        TextureHelper.register(millstone);
        TextureHelper.register(fryer);
        TextureHelper.register(cookingoil);
        
    }
    
}
