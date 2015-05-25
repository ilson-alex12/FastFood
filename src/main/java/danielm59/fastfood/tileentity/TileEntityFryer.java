package danielm59.fastfood.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;

public class TileEntityFryer extends TileEntityFF implements IUpdatePlayerListBox {
    
    public int currentProcessTime;
    
    public TileEntityFryer() {
    
        super();
        inventory = new ItemStack[4];
        
    }
    
    @Override
    public String getName() {
    
        return "Fryer";
        
    }
    
    @Override
    public void update() {
    
        currentProcessTime = 0;
        
        // TODO Added tick process to Fryer
        
    }
    
    public float getProgress() {
    
        return (float) currentProcessTime / 100;
        
    }
    
}
