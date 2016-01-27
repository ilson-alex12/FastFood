package io.github.danielm59.fastfood.tileentity;

import io.github.danielm59.fastfood.recipe.grinder.GrinderRecipe;
import io.github.danielm59.fastfood.recipe.grinder.GrinderRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;

public class TileEntityGrinder extends TileEntityFF implements ITickable 
{
    
    public int currentProcessTime;
    
    public TileEntityGrinder()
    {
        
        super();
        inventory = new ItemStack[2];
        
    }
    
    @Override
    public String getName()
    {
        
        return "Grinder";
        
    }
    
    @Override
    public void update()
    {
        
        if (!worldObj.isRemote)
        {
            
            GrinderRecipe recipe = GrinderRegistry.getInstance().getMatchingRecipe(inventory[0], inventory[1]);
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
                        setInventorySlotContents(0, inventory[0].getItem().getContainerItem(inventory[0]));
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