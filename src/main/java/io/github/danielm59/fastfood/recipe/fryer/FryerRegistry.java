package io.github.danielm59.fastfood.recipe.fryer;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class FryerRegistry
{
    
    private static FryerRegistry           INSTANCE     = new FryerRegistry();
    private final static List<FryerRecipe> FryerRecipes = new ArrayList<FryerRecipe>();
    private final static List<OilRecipe>   OilRecipes   = new ArrayList<OilRecipe>();
                                                        
    private FryerRegistry()
    {
    
    }
    
    public static FryerRegistry getInstance()
    {
        
        return INSTANCE;
    }
    
    public static void addFryerRecipe(FryerRecipe recipe)
    {
        
        FryerRecipes.add(recipe);
    }
    
    public static void addFryerRecipe(ItemStack input, ItemStack output)
    {
        
        addFryerRecipe(new FryerRecipe(input, output));
        
    }
    
    public List<FryerRecipe> getAllFryerRecipes()
    {
        
        return FryerRecipes;
    }
    
    public FryerRecipe getMatchingFryerRecipe(ItemStack inputSlot, ItemStack outputSlot)
    {
        
        for (FryerRecipe recipe : FryerRecipes)
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
    
    public static void addOilRecipe(OilRecipe oilRecipe)
    {
        
        OilRecipes.add(oilRecipe);
    }
    
    public static void addOilRecipe(ItemStack input, ItemStack output)
    {
        
        addOilRecipe(new OilRecipe(input, output));
        
    }
    
    public List<OilRecipe> getAllOilRecipes()
    {
        
        return OilRecipes;
    }
    
    public OilRecipe getMatchingOilRecipe(ItemStack inputSlot, ItemStack outputSlot)
    {
        
        for (OilRecipe recipe : OilRecipes)
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
