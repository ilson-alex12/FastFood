package danielm59.fastfood.tileentity;

import danielm59.fastfood.recipe.churn.ChurnRecipe;
import danielm59.fastfood.recipe.churn.ChurnRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;

public class TileEntityChurn extends TileEntityFF implements IUpdatePlayerListBox
{
    
    public int currentProcessTime;
    
    public TileEntityChurn()
    {
        
        super();
        inventory = new ItemStack[2];
        
    }
    
    @Override
    public String getName()
    {
        
        return "Churn";
        
    }
    
    @Override
    public void update()
    {
        
        if (!worldObj.isRemote)
        {
            
            ChurnRecipe recipe = ChurnRegistry.getInstance().getMatchingRecipe(inventory[0], inventory[1]);
            if (recipe != null)
            {
                if (++currentProcessTime >= 100)
                {
                    this.markDirty();
                    currentProcessTime = 0;
                    if (inventory[1] != null)
                    {
                        inventory[1].stackSize += recipe.getOutput().stackSize;
                    } else
                    {
                        inventory[1] = recipe.getOutput().copy();
                    }
                    if (inventory[0].getItem().hasContainerItem(inventory[0]))
                    {
                        setInventorySlotContents(0, new ItemStack(inventory[0].getItem().getContainerItem()));
                    } else
                    {
                        decrStackSize(0, 1);
                    }
                }
            } else
            {
                currentProcessTime = 0;
            }
        }
    }
    
    public float getProgress()
    {
        
        return (float) currentProcessTime / 100;
        
    }
    
}
