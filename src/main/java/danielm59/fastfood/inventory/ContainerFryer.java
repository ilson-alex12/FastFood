package danielm59.fastfood.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import danielm59.fastfood.tileentity.TileEntityFryer;

public class ContainerFryer extends ContainerFF {
    
    public static final int FRYER_INPUTS  = 3;
    public static final int FRYER_OUTPUTS = 1;
    
    private int             lastProcessTime;
    
    private TileEntityFryer tileEntityFryer;
    
    public ContainerFryer(InventoryPlayer inventory, TileEntityFryer tileEntityFryer, EntityPlayer player) {
    
        this.tileEntityFryer = tileEntityFryer;
        // TODO Add Slot Locations
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
