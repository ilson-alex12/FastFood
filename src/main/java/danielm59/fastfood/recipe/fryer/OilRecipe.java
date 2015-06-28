package danielm59.fastfood.recipe.fryer;

import net.minecraft.item.ItemStack;

public class OilRecipe {
    
    private ItemStack input;
    private ItemStack output;
    
    OilRecipe(ItemStack input, ItemStack output) {
    
        this.input = input;
        this.output = output;
        
    }
    
    public ItemStack getInput() {
    
        return input;
        
    }
    
    public ItemStack getOutput() {
    
        return output;
        
    }
    
}
