package danielm59.fastfood.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import danielm59.fastfood.init.ModItems;
import danielm59.fastfood.reference.Reference;

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
