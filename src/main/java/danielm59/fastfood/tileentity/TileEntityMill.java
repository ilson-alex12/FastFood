package danielm59.fastfood.tileentity;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import danielm59.fastfood.recipe.mill.MillInputRecipe;
import danielm59.fastfood.recipe.mill.MillOutputRecipe;
import danielm59.fastfood.recipe.mill.MillRegistry;

public class TileEntityMill extends TileEntityFF{

	public int currentInputProcessTime;
	public int currentOutputProcessTime;
	public String FlourType;
	public int FlourLevel = 0;
	
	private int MaxFlourLevel = 64;
	
	public TileEntityMill() {
		
		super();
		inventory = new ItemStack[3];
		
	}
	
	public String getName() {
		
		return "Mill";
		
	}
	
	@Override
	public void updateEntity() {
		
		InputUpdate();
		OutputUpdate();
		
	}
	
	public void InputUpdate() {
		
        if (!worldObj.isRemote) {
        	MillInputRecipe recipe = MillRegistry.getInstance().getMatchingInputRecipe(inventory[0], FlourType, getFlourSpace());
        	if (recipe != null) {   
        		 if (++currentInputProcessTime >= 100) {
        			 this.markDirty();
        			 currentInputProcessTime = 0;
        			 FlourLevel = FlourLevel + 2;
        			 FlourType = recipe.getOutput();
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
                 currentInputProcessTime = 0;
             }
         }
	}
	
	public void OutputUpdate() {
		
		if(!worldObj.isRemote) {
			MillOutputRecipe recipe = MillRegistry.getInstance().getMatchingOutputRecipe(FlourType, FlourLevel, inventory[1], inventory[2]);
			if (recipe != null) {
				if (++currentOutputProcessTime >= 40) {
					this.markDirty();
					currentOutputProcessTime = 0;
					--FlourLevel;
					if (FlourLevel == 0) {
						FlourType = null;
					}
					if (inventory[2] != null) {
                   	 inventory[2].stackSize += recipe.getOutput().stackSize;
                    } else {
                   	 inventory[2] = recipe.getOutput().copy();
                    }
                    if (inventory[1].getItem().hasContainerItem())
                    {
                   	 setInventorySlotContents(1, new ItemStack(inventory[1].getItem().getContainerItem()));
                    }
                    else
                    {
                   	 decrStackSize(1, 1);
                    }
				}
			}
		}
		
	}
	
    public float getInputProgress() {
    	
    	return (float) currentInputProcessTime/100;
    	
    }
    
    public float getOutputProgress() {
    	
    	return (float) currentOutputProcessTime/40;
    	
    }
    
    public float getFlourLevel() {
    	
    	return (float) FlourLevel/MaxFlourLevel;
    	
    }
    
    public int getFlourSpace() {
    	
    	return MaxFlourLevel - FlourLevel;
    	
    }
    
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if(i == 0 && inventory[0] == null && getFlourSpace() > 0 ) {
			if (itemstack.getItem() == Items.wheat) {
				return true;
			}
		}
		return false;
	}
	
	@Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
		 super.writeToNBT(nbtTagCompound);
		 nbtTagCompound.setInteger("flourLevel", FlourLevel);
		 if (FlourType != null) {
				 nbtTagCompound.setString("flourType", FlourType);
		 }
		 
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		if (nbtTagCompound.hasKey("flourLevel")) FlourLevel = nbtTagCompound.getInteger("flourLevel");
		if (nbtTagCompound.hasKey("flourType")) FlourType = nbtTagCompound.getString("flourType");
	}

}
