package io.github.danielm59.fastfood.recipe.mill;

import net.minecraft.item.ItemStack;

public class MillOutputRecipe
{
    
    private String    inputFlour;
    private ItemStack inputContainer;
    private ItemStack output;
                      
    MillOutputRecipe(String inputFlour, ItemStack inputContainer, ItemStack output)
    {
        
        this.inputFlour = inputFlour;
        this.inputContainer = inputContainer;
        this.output = output;
        
    }
    
    public String getInputFlour()
    {
        
        return inputFlour;
        
    }
    
    public ItemStack getIntputContainer()
    {
        
        return inputContainer;
        
    }
    
    public ItemStack getOutput()
    {
        
        return output;
        
    }
    
}
