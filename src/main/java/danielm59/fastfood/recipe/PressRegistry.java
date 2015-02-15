package danielm59.fastfood.recipe;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class PressRegistry {

    private static PressRegistry INSTANCE = new PressRegistry();
    private final static List<PressRecipe> pressRecipes = new ArrayList<PressRecipe>();	

    private PressRegistry() {
        
    }
    
    public static PressRegistry getInstance() {
    
        return INSTANCE;
    }
    
    public static void addRecipe(PressRecipe recipe) {
    
        pressRecipes.add(recipe);
    }
    
    public static void addRecipe(ItemStack inputTop, ItemStack inputBottom, ItemStack output) {
    	
    	addRecipe(new PressRecipe(inputTop, inputBottom, output));
    	
    }
    
    public List<PressRecipe> getAllRecipes() {
        
        return pressRecipes;
    }

	public PressRecipe getMatchingRecipe(ItemStack inputTopSlot, ItemStack inputBottomSlot, ItemStack outputSlot) {
		
		for (PressRecipe recipe : pressRecipes) {
			if (inputTopSlot != null) {
				if (recipe.getInputTop().isItemEqual(inputTopSlot)) {
					if (inputBottomSlot != null) {
						if (recipe.getInputBottom().isItemEqual(inputBottomSlot)) {
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
			}
        }
        return null;
    }
    
	
}
