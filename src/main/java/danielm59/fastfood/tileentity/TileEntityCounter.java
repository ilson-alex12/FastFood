package danielm59.fastfood.tileentity;

import net.minecraft.item.ItemStack;

public class TileEntityCounter extends TileEntityFF {
    
    public TileEntityCounter() {
    
        super();
        inventory = new ItemStack[9];
        
    }
    
    @Override
    public String getName() {
    
        return "Counter";
        
    }
    
}
