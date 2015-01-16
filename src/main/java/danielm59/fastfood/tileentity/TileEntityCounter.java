package danielm59.fastfood.tileentity;

import danielm59.fastfood.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IChatComponent;

public class TileEntityCounter extends TileEntityFF {

	
	public TileEntityCounter() {
		
		super();
		inventory = new ItemStack[9];
		
	}

	@Override
	public String getName() {

		return "Counter";
		
	}
	
}
