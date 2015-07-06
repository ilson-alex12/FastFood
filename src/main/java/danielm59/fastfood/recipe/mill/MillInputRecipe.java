package danielm59.fastfood.recipe.mill;

import net.minecraft.item.ItemStack;

public class MillInputRecipe
{
    
    private ItemStack input;
    private String    output;
    
    MillInputRecipe(ItemStack input, String output)
    {
    
        this.input = input;
        this.output = output;
        
    }
    
    public ItemStack getInput()
    {
    
        return input;
        
    }
    
    public String getOutput()
    {
    
        return output;
        
    }
    
}
