package danielm59.fastfood.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;

public class TileEntityFryer extends TileEntityFF implements IUpdatePlayerListBox {
    
    public int currentFryerProcessTime;
    public int currentOilProcessTime;
    
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
    
        currentOilProcessTime = 0;
        // TODO add Oil process
    }
    
    public float getFryerProgress() {
    
        return (float) currentFryerProcessTime / 100;
        
    }
    
    public float getOilProgress() {
    
        return (float) currentOilProcessTime / 100;
        
    }
    
}
