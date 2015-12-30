package danielm59.fastfood.utility;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class TextureHelper
{
    public static void register(Item item)
    {
        
        String name = item.getUnlocalizedName();
        name = name.substring(name.indexOf(".") + 1);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(name, "inventory"));
    }
    
    public static void register(Block block)
    {
        
        Item item = Item.getItemFromBlock(block);
        register(item);
    }
}
