package danielm59.fastfood.recipe.press;

import net.minecraft.item.ItemStack;

public class PressRecipe
{
    
    private ItemStack inputTop;
    private ItemStack inputBottom;
    private ItemStack output;
                      
    PressRecipe(ItemStack inputTop, ItemStack inputBottom, ItemStack output)
    {
        
        this.inputTop = inputTop;
        this.inputBottom = inputBottom;
        this.output = output;
        
    }
    
    public ItemStack getInputTop()
    {
        
        return inputTop;
        
    }
    
    public ItemStack getInputBottom()
    {
        
        return inputBottom;
        
    }
    
    public ItemStack getOutput()
    {
        
        return output;
        
    }
    
}
