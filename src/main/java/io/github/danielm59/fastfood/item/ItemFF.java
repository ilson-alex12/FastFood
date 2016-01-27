package io.github.danielm59.fastfood.item;

import io.github.danielm59.fastfood.creativetab.CreativeTabFF;
import io.github.danielm59.fastfood.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFF extends Item
{
    
    public ItemFF()
    {
        
        super();
        this.setCreativeTab(CreativeTabFF.FF_TAB);
        
    }
    
    @Override
    public String getUnlocalizedName()
    {
        
        return String.format("item.%s%s", Reference.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        
        return String.format("item.%s%s", Reference.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
}
