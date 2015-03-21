package danielm59.fastfood.recipe.churn;

import net.minecraft.item.ItemStack;

	public class ChurnRecipe {

	private ItemStack input;
	private ItemStack output;

	ChurnRecipe(ItemStack input, ItemStack output) {
		
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
