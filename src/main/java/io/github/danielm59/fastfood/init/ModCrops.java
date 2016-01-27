package io.github.danielm59.fastfood.init;

import io.github.danielm59.fastfood.block.crops.BlockCropTomato;
import io.github.danielm59.fastfood.block.crops.BlockCropsFF;
import io.github.danielm59.fastfood.item.seed.ItemSeedFF;
import io.github.danielm59.fastfood.item.seed.ItemSeedTomato;
import io.github.danielm59.fastfood.reference.Reference;
import io.github.danielm59.fastfood.utility.TextureHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModCrops
{
    
    public static final BlockCropsFF tomatocrop  = new BlockCropTomato();
    public static final ItemSeedFF   tomatoseeds = new ItemSeedTomato();
                                                 
    public static void init()
    {
        
        GameRegistry.registerBlock(tomatocrop, "tomatocrop");
        GameRegistry.registerItem(tomatoseeds, "tomatoseeds");
        
        MinecraftForge.addGrassSeed(new ItemStack(tomatoseeds), 10);
        
    }
    
    @SideOnly(Side.CLIENT)
    public static void textures()
    {
        
        TextureHelper.register(tomatoseeds);
        
    }
    
}
