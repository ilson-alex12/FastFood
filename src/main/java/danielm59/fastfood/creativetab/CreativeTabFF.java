package danielm59.fastfood.creativetab;

import danielm59.fastfood.init.ModItems;
import danielm59.fastfood.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabFF
{
    
    public static final CreativeTabs FF_TAB = new CreativeTabs(Reference.MODID.toLowerCase())
    {
        
        @Override
        public Item getTabIconItem()
        {
            
            return ModItems.knife;
        }
    };
    
}
