package danielm59.fastfood.utility;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemHelper {
    
    public static ItemStack cloneItemStack(ItemStack itemStack, int stackSize) {
    
        ItemStack clonedItemStack = itemStack.copy();
        clonedItemStack.stackSize = stackSize;
        return clonedItemStack;
    }
    
    public static boolean equalsIgnoreStackSize(ItemStack itemStack1, ItemStack itemStack2) {
    
        if (itemStack1 != null && itemStack2 != null) {
            // Sort on itemID
            if (Item.getIdFromItem(itemStack1.getItem()) - Item.getIdFromItem(itemStack2.getItem()) == 0) {
                // Then sort on meta
                if (itemStack1.getItemDamage() == itemStack2.getItemDamage()) {
                    // Then sort on NBT
                    if (itemStack1.hasTagCompound() && itemStack2.hasTagCompound()) {
                        // Then sort on stack size
                        if (itemStack1.getTagCompound().equals(itemStack2.getTagCompound())) { return true; }
                    } else {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
}
