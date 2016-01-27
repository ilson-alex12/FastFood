package io.github.danielm59.fastfood.item;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class FoodDrinkableFF extends FoodFF
{
    
    public FoodDrinkableFF(int hunger, float saturation, boolean wolf)
    {
        
        super(hunger, saturation, wolf);
        
    }
    
    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        
        return EnumAction.DRINK;
        
    }
    
}
