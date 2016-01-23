package danielm59.fastfood.recipe.mill;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class MillRegistry
{
    
    private static MillRegistry                 INSTANCE          = new MillRegistry();
    private final static List<MillInputRecipe>  MillInputRecipes  = new ArrayList<MillInputRecipe>();
    private final static List<MillOutputRecipe> MillOutputRecipes = new ArrayList<MillOutputRecipe>();
                                                                  
    private MillRegistry()
    {
    
    }
    
    public static MillRegistry getInstance()
    {
        
        return INSTANCE;
    }
    
    public static void addInputRecipe(MillInputRecipe recipe)
    {
        
        MillInputRecipes.add(recipe);
    }
    
    public static void addInputRecipe(ItemStack input, String output)
    {
        
        addInputRecipe(new MillInputRecipe(input, output));
        
    }
    
    public static void addOutputRecipe(MillOutputRecipe recipe)
    {
        
        MillOutputRecipes.add(recipe);
    }
    
    public static void addOutputRecipe(String inputFlour, ItemStack inputContainer, ItemStack output)
    {
        
        addOutputRecipe(new MillOutputRecipe(inputFlour, inputContainer, output));
        
    }
    
    public List<MillInputRecipe> getAllInputRecipes()
    {
        
        return MillInputRecipes;
    }
    
    public List<MillOutputRecipe> getAllOuputRecipes()
    {
        
        return MillOutputRecipes;
    }
    
    public MillInputRecipe getMatchingInputRecipe(ItemStack input, String output, int FlourSpace)
    {
        
        for (MillInputRecipe recipe : MillInputRecipes)
        {
            if (input != null)
            {
                if (recipe.getInput().isItemEqual(input))
                {
                    if (output != null)
                    {
                        String craftingResult = recipe.getOutput();
                        if (!(output.equalsIgnoreCase(craftingResult)))
                        {
                            continue;
                        } else if ((FlourSpace - 2 < 0))
                        {
                            continue;
                        }
                    }
                    return recipe;
                }
            }
        }
        return null;
    }
    
    public MillOutputRecipe getMatchingOutputRecipe(String inputFlour, int flourLevel, ItemStack inputContainer, ItemStack output)
    {
        
        for (MillOutputRecipe recipe : MillOutputRecipes)
        {
            if (inputFlour != null && flourLevel > 0 && inputContainer != null)
            {
                if (recipe.getIntputContainer().isItemEqual(inputContainer) && recipe.getInputFlour().equalsIgnoreCase(inputFlour))
                {
                    if (output != null)
                    {
                        ItemStack craftingResult = recipe.getOutput();
                        if (!ItemStack.areItemStackTagsEqual(output, craftingResult) || !output.isItemEqual(craftingResult))
                        {
                            continue;
                        } else if (craftingResult.stackSize + output.stackSize > output.getMaxStackSize())
                        {
                            continue;
                        }
                    }
                    return recipe;
                }
            }
        }
        return null;
    }
    
}
