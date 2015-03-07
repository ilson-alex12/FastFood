package danielm59.fastfood.recipe.churn;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class ChurnRegistry {

    private static ChurnRegistry INSTANCE = new ChurnRegistry();
    private final static List<ChurnRecipe> ChurnRecipes = new ArrayList<ChurnRecipe>();	

    private ChurnRegistry() {
        
    }
    
    public static ChurnRegistry getInstance() {
    
        return INSTANCE;
    }
    
    public static void addRecipe(ChurnRecipe recipe) {
    
        ChurnRecipes.add(recipe);
    }
    
    public static void addRecipe(ItemStack input, ItemStack output) {
    	
    	addRecipe(new ChurnRecipe(input, output));
    	
    }
    
    public List<ChurnRecipe> getAllRecipes() {
        
        return ChurnRecipes;
    }

	public ChurnRecipe getMatchingRecipe(ItemStack inputSlot, ItemStack outputSlot) {
		
		for (ChurnRecipe recipe : ChurnRecipes) {
			if (inputSlot != null) {
				if (recipe.getInput().isItemEqual(inputSlot)) {
                    if (outputSlot != null) {
                        ItemStack craftingResult = recipe.getOutput();
                        if (!ItemStack.areItemStackTagsEqual(outputSlot, craftingResult) || !outputSlot.isItemEqual(craftingResult)) {
                            continue;
                        } else if (craftingResult.stackSize + outputSlot.stackSize > outputSlot.getMaxStackSize()) {
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
