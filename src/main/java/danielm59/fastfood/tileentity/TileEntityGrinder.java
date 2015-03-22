package danielm59.fastfood.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import danielm59.fastfood.recipe.grinder.GrinderRecipe;
import danielm59.fastfood.recipe.grinder.GrinderRegistry;

public class TileEntityGrinder extends TileEntityFF implements IUpdatePlayerListBox {
	
	public int currentProcessTime;
	
	public TileEntityGrinder() {
		
		super();
		inventory = new ItemStack[2];
		
	}

	@Override
	public String getName() {

		return "Grinder";
		
	}
    
    @Override
    public void update() {
    
        if (!worldObj.isRemote) {

        	GrinderRecipe recipe = GrinderRegistry.getInstance().getMatchingRecipe(inventory[0], inventory[1]);
			if (recipe != null) {   
        		 if (++currentProcessTime >= 100) {
        			 this.markDirty();
        			 currentProcessTime = 0;
                     if (inventory[1] != null) {
                    	 inventory[1].stackSize += recipe.getOutput().stackSize;
                     } else {
                    	 inventory[1] = recipe.getOutput().copy();
                     }
                     if (inventory[0].getItem().hasContainerItem())
                     {
                    	 setInventorySlotContents(0, new ItemStack(inventory[0].getItem().getContainerItem()));
                     }
                     else
                     {
                    	 decrStackSize(0, 1);
                     }
                 }
             } else {
                 currentProcessTime = 0;
             }
         }  
    }
    
    public float getProgress() {
    	
    	return (float) currentProcessTime/100;
    	
    }
}
