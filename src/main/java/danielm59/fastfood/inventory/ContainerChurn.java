package danielm59.fastfood.inventory;

import danielm59.fastfood.inventory.slots.SlotOutput;
import danielm59.fastfood.tileentity.TileEntityChurn;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerChurn extends ContainerFF
{
    
    public static final int CHURN_INPUTS  = 1;
    public static final int CHURN_OUTPUTS = 1;
                                          
    private int             lastProcessTime;
                            
    private TileEntityChurn tileEntityChurn;
                            
    public ContainerChurn(InventoryPlayer inventory, TileEntityChurn tileEntityChurn, EntityPlayer player)
    {
        
        this.tileEntityChurn = tileEntityChurn;
        tileEntityChurn.openInventory(player);
        
        // Add the Input slots to the container
        for (int InputIndex = 0; InputIndex < CHURN_INPUTS; ++InputIndex)
        {
            
            this.addSlotToContainer(new Slot(tileEntityChurn, InputIndex, 56, 35 + InputIndex * 18));
            
        }
        
        // Add the Output slots to the container
        for (int OutputIndex = 0; OutputIndex < CHURN_OUTPUTS; ++OutputIndex)
        {
            
            this.addSlotToContainer(new SlotOutput(tileEntityChurn, CHURN_INPUTS + OutputIndex, 116, 35 + OutputIndex * 18));
            
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
        tileEntityChurn.closeInventory(entityPlayer);
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
            
            if (slotIndex < CHURN_INPUTS + CHURN_OUTPUTS)
            {
                if (!this.mergeItemStack(itemStack, CHURN_INPUTS + CHURN_OUTPUTS, inventorySlots.size(), false)) { return null; }
            } else if (!this.mergeItemStack(itemStack, 0, CHURN_INPUTS + CHURN_OUTPUTS, false)) { return null; }
            
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
    
    @Override
    public void addCraftingToCrafters(ICrafting iCrafting)
    {
        
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityChurn.currentProcessTime);
        
    }
    
    @Override
    public void detectAndSendChanges()
    {
        
        super.detectAndSendChanges();
        
        for (Object crafter : this.crafters)
        {
            ICrafting icrafting = (ICrafting) crafter;
            
            if (this.lastProcessTime != this.tileEntityChurn.currentProcessTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityChurn.currentProcessTime);
            }
            
        }
        
        this.lastProcessTime = this.tileEntityChurn.currentProcessTime;
        
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int valueType, int updatedValue)
    {
        
        if (valueType == 0)
        {
            this.tileEntityChurn.currentProcessTime = updatedValue;
        }
        
    }
    
}
