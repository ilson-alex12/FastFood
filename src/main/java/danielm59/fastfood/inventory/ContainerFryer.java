package danielm59.fastfood.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import danielm59.fastfood.inventory.slots.SlotOutput;
import danielm59.fastfood.tileentity.TileEntityFryer;

public class ContainerFryer extends ContainerFF {
    
    public static final int FRYER_INPUTS  = 3;
    public static final int FRYER_OUTPUTS = 1;
    
    private int             lastProcessTime;
    
    private TileEntityFryer tileEntityFryer;
    
    public ContainerFryer(InventoryPlayer inventory, TileEntityFryer tileEntityFryer, EntityPlayer player) {
    
        this.tileEntityFryer = tileEntityFryer;
        tileEntityFryer.openInventory(player);
        
        //TODO Add the Input slots to the container
        for (int InputIndex = 0; InputIndex < FRYER_INPUTS; ++InputIndex) {
            
            this.addSlotToContainer(new Slot(tileEntityFryer, InputIndex, 56, 35 + InputIndex * 18));
            
        }
        
        //TODO Add the Output slots to the container
        for (int OutputIndex = 0; OutputIndex < FRYER_OUTPUTS; ++OutputIndex) {
            
            this.addSlotToContainer(new SlotOutput(tileEntityFryer, FRYER_INPUTS + OutputIndex, 116, 35 + OutputIndex * 18));
            
        }
        
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
            
            if (slotIndex < FRYER_INPUTS + FRYER_OUTPUTS) {
                if (!this.mergeItemStack(itemStack, FRYER_INPUTS + FRYER_OUTPUTS, inventorySlots.size(), false)) { return null; }
            } else if (!this.mergeItemStack(itemStack, 0, FRYER_INPUTS + FRYER_OUTPUTS, false)) { return null; }
            
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
