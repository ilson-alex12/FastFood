package danielm59.fastfood.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;

public class TileEntityFryer extends TileEntityFF implements IUpdatePlayerListBox {
    
    public TileEntityFryer() {
    
        super();
        inventory = new ItemStack[4];
        
    }
    
    @Override
    public void update() {
    
        // TODO Auto-generated method stub
        
    }
    
}
