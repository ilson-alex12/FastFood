package danielm59.fastfood.recipe.grinder;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class GrinderRegistry
{
    
    private static GrinderRegistry           INSTANCE       = new GrinderRegistry();
    private final static List<GrinderRecipe> grinderRecipes = new ArrayList<GrinderRecipe>();
    
    private GrinderRegistry()
    {
    
    }
    
    public static GrinderRegistry getInstance()
    {
    
        return INSTANCE;
    }
    
    public static void addRecipe(GrinderRecipe recipe)
    {
    
        grinderRecipes.add(recipe);
    }
    
    public static void addRecipe(ItemStack input, ItemStack output)
    {
    
        addRecipe(new GrinderRecipe(input, output));
        
    }
    
    public List<GrinderRecipe> getAllRecipes()
    {
    
        return grinderRecipes;
    }
    
    public GrinderRecipe getMatchingRecipe(ItemStack inputSlot, ItemStack outputSlot)
    {
    
        for (GrinderRecipe recipe : grinderRecipes)
        {
            if (inputSlot != null)
            {
                if (recipe.getInput().isItemEqual(inputSlot))
                {
                    if (outputSlot != null)
                    {
                        ItemStack craftingResult = recipe.getOutput();
                        if (!ItemStack.areItemStackTagsEqual(outputSlot, craftingResult) || !outputSlot.isItemEqual(craftingResult))
                        {
                            continue;
                        } else if (craftingResult.stackSize + outputSlot.stackSize > outputSlot.getMaxStackSize())
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
