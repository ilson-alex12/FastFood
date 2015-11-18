package danielm59.fastfood.init;

import danielm59.fastfood.block.BlockChurn;
import danielm59.fastfood.block.BlockCounter;
import danielm59.fastfood.block.BlockFF;
import danielm59.fastfood.block.BlockFryer;
import danielm59.fastfood.block.BlockGrinder;
import danielm59.fastfood.block.BlockMill;
import danielm59.fastfood.block.BlockPress;
import danielm59.fastfood.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModBlocks
{
    
    public static final BlockFF counter = new BlockCounter();
    public static final BlockFF grinder = new BlockGrinder();
    public static final BlockFF churn   = new BlockChurn();
    public static final BlockFF press   = new BlockPress();
    public static final BlockFF mill    = new BlockMill();
    public static final BlockFF fryer   = new BlockFryer();
                                        
    public static void init()
    {
        
        GameRegistry.registerBlock(counter, "counter");
        GameRegistry.registerBlock(grinder, "grinder");
        GameRegistry.registerBlock(churn, "churn");
        GameRegistry.registerBlock(press, "press");
        GameRegistry.registerBlock(mill, "mill");
        GameRegistry.registerBlock(fryer, null, "fryer");
        
    }
    
    @SideOnly(Side.CLIENT)
    public static void textures()
    {
        
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(counter), 0, new ModelResourceLocation("fastfood:counter", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(grinder), 0, new ModelResourceLocation("fastfood:grinder", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(churn), 0, new ModelResourceLocation("fastfood:churn", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(press), 0, new ModelResourceLocation("fastfood:press", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(mill), 0, new ModelResourceLocation("fastfood:mill", "inventory"));
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(fryer), 0, new ModelResourceLocation("fastfood:fryer", "inventroy"));
    }
    
}
