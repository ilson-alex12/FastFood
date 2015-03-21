package danielm59.fastfood.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import danielm59.fastfood.recipe.press.PressRecipe;
import danielm59.fastfood.recipe.press.PressRegistry;

public class TileEntityPress extends TileEntityFF implements IUpdatePlayerListBox {

	public int currentProcessTime;
	
	public TileEntityPress(){
		
		super();
		inventory = new ItemStack[3];
		
	}

	public String getName() {

		return "Press";
		
	}
    
    @Override
    public void update() {
    
        if (!worldObj.isRemote) {

        	PressRecipe recipe = PressRegistry.getInstance().getMatchingRecipe(inventory[0], inventory[1], inventory[2]);
			if (recipe != null) {   
        		 if (++currentProcessTime >= 100) {
        			 this.markDirty();
        			 currentProcessTime = 0;
                     if (inventory[2] != null) {
                    	 inventory[2].stackSize += recipe.getOutput().stackSize;
                     } else {
                    	 inventory[2] = recipe.getOutput().copy();
                     }
                     if (inventory[0].getItem().hasContainerItem())
                     {
                    	 setInventorySlotContents(0, new ItemStack(inventory[0].getItem().getContainerItem()));
                     }
                     if (inventory[1].getItem().hasContainerItem())
                     {
                    	 setInventorySlotContents(1, new ItemStack(inventory[1].getItem().getContainerItem()));
                     }
                     else
                     {
                    	 decrStackSize(0, 1);
                    	 decrStackSize(1, 1);
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
