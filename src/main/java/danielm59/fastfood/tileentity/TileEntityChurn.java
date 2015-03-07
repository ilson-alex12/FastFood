package danielm59.fastfood.tileentity;

import danielm59.fastfood.recipe.ChurnRecipe;
import danielm59.fastfood.recipe.ChurnRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;



public class TileEntityChurn extends TileEntityFF implements IUpdatePlayerListBox {

	public int currentProcessTime;
	public boolean activeUpdate;
	
	public TileEntityChurn() {
		
		super();
		inventory = new ItemStack[2];
		
	}

	@Override
	public String getName() {

		return "Churn";
		
	}
    
    @Override
    public void update() {    
    	
//		System.out.println("TileEntityChurn.update(): side:" + (worldObj.isRemote ? "client" : "server")
//      	+ " currentProcessTime:" + currentProcessTime);
    	
	ChurnRecipe recipe = ChurnRegistry.getInstance().getMatchingRecipe(inventory[0], inventory[1]);
	if (recipe != null) {
		 if (++currentProcessTime >= 100) {
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
	 checkUpdate();
    }
    
	protected void checkUpdate() {
		
//		System.out.print("   TileEntityChurn.checkUpdate(): isActive()=" + isActive() + ", activeUpdate=" + activeUpdate);
		
		if (isActive() != activeUpdate) {
			activeUpdate = isActive();
			
//			System.out.print(" -> block updated");
			
			worldObj.notifyBlockOfStateChange(pos, worldObj.getBlockState(pos).getBlock());
			worldObj.markBlockForUpdate(pos);
		}
	}
    
    public boolean isActive() {
		boolean active = (currentProcessTime>0);
    	return active;	
	}

	public float getProgress() {
    	
    	return (float) currentProcessTime/100;
    	
    }
	
}
