package danielm59.fastfood.inventory;

import danielm59.fastfood.inventory.slots.SlotOutput;
import danielm59.fastfood.tileentity.TileEntityMill;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerMill extends ContainerFF
{
    
    public static final int MILL_HIDDEN_INPUTS = 1;
    public static final int MILL_INPUTS        = 1;
    public static final int MILL_OUTPUTS       = 1;
                                               
    private int             lastInputProcessTime;
    private int             lastOutputProcessTime;
    private int             lastFlourLevel;
                            
    private TileEntityMill  tileEntityMill;
                            
    public ContainerMill(InventoryPlayer inventory, TileEntityMill tileEntityMill, EntityPlayer player)
    {
        
        this.tileEntityMill = tileEntityMill;
        tileEntityMill.openInventory(player);
        
        // Add the Input slots to the container
        for (int InputIndex = 0; InputIndex < MILL_INPUTS; ++InputIndex)
        {
            
            this.addSlotToContainer(new Slot(tileEntityMill, MILL_HIDDEN_INPUTS + InputIndex, 86, 47 + InputIndex * 18));
            
        }
        
        // Add the Output slots to the container
        for (int OutputIndex = 0; OutputIndex < MILL_OUTPUTS; ++OutputIndex)
        {
            
            this.addSlotToContainer(new SlotOutput(tileEntityMill, MILL_HIDDEN_INPUTS + MILL_INPUTS + OutputIndex, 146, 47 + OutputIndex * 18));
            
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
        tileEntityMill.closeInventory(entityPlayer);
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
            
            if (slotIndex < MILL_INPUTS + MILL_OUTPUTS)
            {
                if (!this.mergeItemStack(itemStack, MILL_INPUTS + MILL_OUTPUTS, inventorySlots.size(), false)) { return null; }
            } else if (!this.mergeItemStack(itemStack, 0, MILL_INPUTS + MILL_OUTPUTS, false)) { return null; }
            
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
        iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityMill.currentInputProcessTime);
        iCrafting.sendProgressBarUpdate(this, 1, this.tileEntityMill.currentOutputProcessTime);
        iCrafting.sendProgressBarUpdate(this, 2, this.tileEntityMill.FlourLevel);
        
    }*/
    
    @Override
    public void detectAndSendChanges()
    {
        
        super.detectAndSendChanges();
        
        for (Object crafter : this.crafters)
        {
            ICrafting icrafting = (ICrafting) crafter;
            
            if (this.lastInputProcessTime != this.tileEntityMill.currentInputProcessTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityMill.currentInputProcessTime);
            }
            if (this.lastOutputProcessTime != this.tileEntityMill.currentOutputProcessTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntityMill.currentOutputProcessTime);
            }
            if (this.lastFlourLevel != this.tileEntityMill.FlourLevel)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.tileEntityMill.FlourLevel);
            }
            
        }
        
        this.lastInputProcessTime = this.tileEntityMill.currentInputProcessTime;
        this.lastOutputProcessTime = this.tileEntityMill.currentOutputProcessTime;
        this.lastFlourLevel = this.tileEntityMill.FlourLevel;
        
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int valueType, int updatedValue)
    {
        
        if (valueType == 0)
        {
            this.tileEntityMill.currentInputProcessTime = updatedValue;
        }
        if (valueType == 1)
        {
            this.tileEntityMill.currentOutputProcessTime = updatedValue;
        }
        if (valueType == 2)
        {
            this.tileEntityMill.FlourLevel = updatedValue;
        }
    }
}
