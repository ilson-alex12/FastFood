package danielm59.fastfood.item;

import net.minecraft.item.ItemStack;

public class ItemKnife extends ItemFF{
	
	public ItemKnife(){
		
		super();
		this.setUnlocalizedName("knife");
		this.setMaxStackSize(1);
		this.setMaxDamage(128);
		
	}
	
    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack){
    	
        return false;
        
    }
    
    @Override
    public ItemStack getContainerItem(ItemStack itemStack){
    	
        ItemStack copiedStack = itemStack.copy();

        copiedStack.setItemDamage(copiedStack.getItemDamage() + 1);
        copiedStack.stackSize = 1;

        return copiedStack;
        
    }

}
