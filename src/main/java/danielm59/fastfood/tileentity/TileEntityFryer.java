package danielm59.fastfood.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import danielm59.fastfood.recipe.fryer.FryerRegistry;
import danielm59.fastfood.recipe.fryer.OilRecipe;

public class TileEntityFryer extends TileEntityFF implements IUpdatePlayerListBox {
    
    public int  currentFryerProcessTime;
    public int  currentOilProcessTime;
    public int  oilLevel;
    
    private int maxOil = 10000;
    private int addOil = 1000;
    
    public TileEntityFryer() {
    
        super();
        inventory = new ItemStack[5];
        
    }
    
    @Override
    public String getName() {
    
        return "Fryer";
        
    }
    
    @Override
    public void update() {
    
        updateFryer();
        updateOil();
        
    }
    
    public void updateFryer() {
    
        currentFryerProcessTime = 0;
        // TODO add Fryer process
    }
    
    public void updateOil() {
    
        if (!worldObj.isRemote) {
            
            OilRecipe recipe = FryerRegistry.getInstance().getMatchingOilRecipe(inventory[2], inventory[3]);
            if (recipe != null && oilLevel <= maxOil - addOil) {
                if (++currentOilProcessTime >= 100) {
                    this.markDirty();
                    currentOilProcessTime = 0;
                    if (inventory[3] != null) {
                        inventory[3].stackSize += recipe.getOutput().stackSize;
                    } else {
                        inventory[3] = recipe.getOutput().copy();
                    }
                    decrStackSize(0, 1);
                    oilLevel = oilLevel + addOil;
                }
            } else {
                currentOilProcessTime = 0;
            }
        }
    }
    
    public float getFryerProgress() {
    
        return (float) currentFryerProcessTime / 100;
        
    }
    
    public float getOilProgress() {
    
        return (float) currentOilProcessTime / 100;
        
    }
    
}
