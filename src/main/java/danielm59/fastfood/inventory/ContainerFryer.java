package danielm59.fastfood.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import danielm59.fastfood.inventory.slots.SlotOutput;
import danielm59.fastfood.tileentity.TileEntityFryer;

public class ContainerFryer extends ContainerFF {
    
    public static final int TOTAL_SLOTS = 5;
    
    private int             lastProcessTime;
    
    private TileEntityFryer tileEntityFryer;
    
    public ContainerFryer(InventoryPlayer inventory, TileEntityFryer tileEntityFryer, EntityPlayer player) {
    
        this.tileEntityFryer = tileEntityFryer;
        tileEntityFryer.openInventory(player);
        
        this.addSlotToContainer(new Slot(tileEntityFryer, 3, 26, 17));
        this.addSlotToContainer(new SlotOutput(tileEntityFryer, 2, 26, 53));
        this.addSlotToContainer(new Slot(tileEntityFryer, 0, 62, 17));
        this.addSlotToContainer(new SlotFurnaceFuel(tileEntityFryer, 1, 62, 53));
        this.addSlotToContainer(new SlotOutput(tileEntityFryer, 2, 122, 35));
        
        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex) {
            
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex) {
                
                this.addSlotToContainer(new Slot((IInventory) inventory, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18, 84 + inventoryRowIndex * 18));
                
            }
            
        }
        
        // Add the player's hot bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarSlotIndex) {
            
            this.addSlotToContainer(new Slot((IInventory) inventory, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
            
        }
    }
    
    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
    
        super.onContainerClosed(entityPlayer);
        
        tileEntityFryer.closeInventory(entityPlayer);
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
    
        ItemStack newItemStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);
        
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack = slot.getStack();
            newItemStack = itemStack.copy();
            
            if (slotIndex < TOTAL_SLOTS) {
                if (!this.mergeItemStack(itemStack, TOTAL_SLOTS, inventorySlots.size(), false)) { return null; }
            } else if (!this.mergeItemStack(itemStack, 0, TOTAL_SLOTS, false)) { return null; }
            
            if (itemStack.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }
        
        return newItemStack;
    }
    
    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
    
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityFryer.currentProcessTime);
        
    }
    
    @Override
    public void detectAndSendChanges() {
    
        super.detectAndSendChanges();
        
        for (Object crafter : this.crafters) {
            ICrafting icrafting = (ICrafting) crafter;
            
            if (this.lastProcessTime != this.tileEntityFryer.currentProcessTime) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityFryer.currentProcessTime);
            }
            
        }
        
        this.lastProcessTime = this.tileEntityFryer.currentProcessTime;
        
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int valueType, int updatedValue) {
    
        if (valueType == 0) {
            this.tileEntityFryer.currentProcessTime = updatedValue;
        }
        
    }
    
}
