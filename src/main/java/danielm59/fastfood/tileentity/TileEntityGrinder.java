package danielm59.fastfood.tileentity;

import danielm59.fastfood.recipe.GrinderRecipe;
import danielm59.fastfood.recipe.GrinderRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.IChatComponent;

public class TileEntityGrinder extends TileEntityFF implements IInventory, IUpdatePlayerListBox {
	
	private ItemStack[] inventory;
	public int currentProcessTime;
	
	public TileEntityGrinder() {
		
		super();
		inventory = new ItemStack[2];
		
	}

	@Override
	public int getSizeInventory() {
		
		return inventory.length;
		
	}

	@Override
	public ItemStack getStackInSlot(int slotIndex) {
		
		return inventory[slotIndex];
		
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int decrementAmount) {

		ItemStack itemStack = getStackInSlot(slotIndex);
        if (itemStack != null)
        {
            
        	if (itemStack.getItem().hasContainerItem())
            {
            	setInventorySlotContents(slotIndex, new ItemStack (itemStack.getItem().getContainerItem(), 1));    	
            }
            else if (itemStack.stackSize <= decrementAmount)
            {
                setInventorySlotContents(slotIndex, null);
            }
            else
            {
                itemStack = itemStack.splitStack(decrementAmount);
                if (itemStack.stackSize == 0)
                {
                    setInventorySlotContents(slotIndex, null);
                }
            }
        }

        return itemStack;
		
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex) {

		   if (inventory[slotIndex] != null)
	        {
	            ItemStack itemStack = inventory[slotIndex];
	            inventory[slotIndex] = null;
	            return itemStack;
	        }
	        else
	        {
	            return null;
	        }
		
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack itemStack) {

        inventory[slotIndex] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }


        this.markDirty();
		
	}

	@Override
	public String getName() {

		return "Grinder";
		
	}

	@Override
	public boolean hasCustomName() {
		
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		
		return 64;
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
		
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack) {
		
		return true;
	}
	
	@Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList("Items", 10);
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i)
        {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < inventory.length)
            {
                inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex)
        {
            if (inventory[currentIndex] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
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
                     decrStackSize(0, 1);
                 }
             } else {
                 currentProcessTime = 0;
             }
         }  
    }
    
    public float getProgress() {
    	
    	return (float) currentProcessTime/100;
    	
    }

	@Override
	public IChatComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeInventory(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openInventory(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		
	}
}
