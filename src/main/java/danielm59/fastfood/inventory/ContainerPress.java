package danielm59.fastfood.inventory;

import danielm59.fastfood.inventory.slots.SlotOutput;
import danielm59.fastfood.tileentity.TileEntityPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerPress extends ContainerFF
{
    
    public static final int PRESS_INPUTS  = 2;
    public static final int PRESS_OUTPUTS = 1;
                                          
    private int             lastProcessTime;
                            
    private TileEntityPress tileEntityPress;
                            
    public ContainerPress(InventoryPlayer inventory, TileEntityPress tileEntityPress, EntityPlayer player)
    {
        
        this.tileEntityPress = tileEntityPress;
        tileEntityPress.openInventory(player);
        
        // Add the Input slots to the container
        for (int InputIndex = 0; InputIndex < PRESS_INPUTS; ++InputIndex)
        {
            
            this.addSlotToContainer(new Slot(tileEntityPress, InputIndex, 56, 26 + InputIndex * 18));
            
        }
        
        // Add the Output slots to the container
        for (int OutputIndex = 0; OutputIndex < PRESS_OUTPUTS; ++OutputIndex)
        {
            
            this.addSlotToContainer(new SlotOutput(tileEntityPress, PRESS_INPUTS + OutputIndex, 116, 35 + OutputIndex * 18));
            
        }
        
        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_INVENTORY_ROWS; ++inventoryRowIndex)
        {
            
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_INVENTORY_COLUMNS; ++inventoryColumnIndex)
            {
                
                this.addSlotToContainer(new Slot((IInventory) inventory, inventoryColumnIndex + inventoryRowIndex * 9 + 9, 8 + inventoryColumnIndex * 18, 84 + inventoryRowIndex * 18));
                
            }
            
        }
        
        // Add the player's hot bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_INVENTORY_COLUMNS; ++actionBarSlotIndex)
        {
            
            this.addSlotToContainer(new Slot((IInventory) inventory, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
            
        }
        
    }
    
    @Override
    public void onContainerClosed(EntityPlayer entityPlayer)
    {
        
        super.onContainerClosed(entityPlayer);
        tileEntityPress.closeInventory(entityPlayer);
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
            
            if (slotIndex < PRESS_INPUTS + PRESS_OUTPUTS)
            {
                if (!this.mergeItemStack(itemStack, PRESS_INPUTS + PRESS_OUTPUTS, inventorySlots.size(), false)) { return null; }
            } else if (!this.mergeItemStack(itemStack, 0, PRESS_INPUTS + PRESS_OUTPUTS, false)) { return null; }
            
            if (itemStack.stackSize == 0)
            {
                slot.putStack(null);
            } else
            {
                slot.onSlotChanged();
            }
        }
        
        return newItemStack;
    }
    
/*    @Override
    public void addCraftingToCrafters(ICrafting iCrafting)
    {
        
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityPress.currentProcessTime);
        
    }*/
    
    @Override
    public void detectAndSendChanges()
    {
        
        super.detectAndSendChanges();
        
        for (Object crafter : this.crafters)
        {
            ICrafting icrafting = (ICrafting) crafter;
            
            if (this.lastProcessTime != this.tileEntityPress.currentProcessTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityPress.currentProcessTime);
            }
            
        }
        
        this.lastProcessTime = this.tileEntityPress.currentProcessTime;
        
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int valueType, int updatedValue)
    {
        
        if (valueType == 0)
        {
            this.tileEntityPress.currentProcessTime = updatedValue;
        }
        
    }
    
}
