package danielm59.fastfood.recipe.grinder;

import net.minecraft.item.ItemStack;

public class GrinderRecipe
{
    
    private ItemStack input;
    private ItemStack output;
                      
    GrinderRecipe(ItemStack input, ItemStack output)
    {
        
        this.input = input;
        this.output = output;
        
    }
    
    public ItemStack getInput()
    {
        
        return input;
        
    }
    
    public ItemStack getOutput()
    {
        
        return output;
        
    }
    
}
