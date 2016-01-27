package io.github.danielm59.fastfood.item;

import net.minecraft.item.ItemStack;

public class ItemGrater extends ItemFF
{
    
    public ItemGrater()
    {
        
        super();
        this.setUnlocalizedName("grater");
        this.setMaxStackSize(1);
        this.setMaxDamage(128);
        this.setNoRepair();
        
    }
    
    @Override
    public boolean getShareTag()
    {
        
        return true;
        
    }
    
    public boolean hasContainerItem(ItemStack itemStack)
    {
        
        return true;
    }
    
    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        
        ItemStack copiedStack = itemStack.copy();
        
        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
        copiedStack.stackSize = 1;
        
        return copiedStack;
        
    }
    
}
