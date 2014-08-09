package danielm59.fastfood.inventory;

import danielm59.fastfood.tileentity.TileEntityCounter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCounter extends ContainerFF {

    public static final int COUNTER_INVENTORY_ROWS = 3;
    public static final int COUNTER_INVENTORY_COLUMNS = 3;
    public static final int COUNTER_INVENTORY_SIZE = COUNTER_INVENTORY_ROWS * COUNTER_INVENTORY_COLUMNS;
	
    private TileEntityCounter tileEntityCounter;
    private int chestInventoryRows;
    private int chestInventoryColumns;
    
    public ContainerCounter(InventoryPlayer inventoryPlayer, TileEntityCounter tileEntityCounter) {
    	
    	this.tileEntityCounter = tileEntityCounter;
        tileEntityCounter.openInventory();
        
        chestInventoryRows = COUNTER_INVENTORY_ROWS;
        chestInventoryColumns = COUNTER_INVENTORY_COLUMNS;
        
     // Add the Counter slots to the container
        for (int chestRowIndex = 0; chestRowIndex < chestInventoryRows; ++chestRowIndex) {
        	
        	for (int chestColumnIndex = 0; chestColumnIndex < chestInventoryColumns; ++chestColumnIndex) {
        		
        		this.addSlotToContainer(new Slot(tileEntityCounter, chestColumnIndex + chestRowIndex * chestInventoryColumns, 62 + chestColumnIndex * 18, 17 + chestRowIndex * 18));
        		
        	}
        	
        }
        
     // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex) {
        	
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex) {

            	this.addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18, 84 + inventoryRowIndex * 18));
    	
            }
            
        }
        
     // Add the player's hot bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarSlotIndex) {

                this.addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
                
        }
            	
    }
    
    @Override
    public void onContainerClosed(EntityPlayer entityPlayer)
    {
        super.onContainerClosed(entityPlayer);
        tileEntityCounter.closeInventory();
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
    {
        ItemStack newItemStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack = slot.getStack();
            newItemStack = itemStack.copy();

            if (slotIndex < chestInventoryRows * chestInventoryColumns)
            {
                if (!this.mergeItemStack(itemStack, chestInventoryRows * chestInventoryColumns, inventorySlots.size(), false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemStack, 0, chestInventoryRows * chestInventoryColumns, false))
            {
                return null;
            }

            if (itemStack.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return newItemStack;
    }
    
}
