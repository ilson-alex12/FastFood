package danielm59.fastfood.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import danielm59.fastfood.client.gui.inventory.GuiCounter;
import danielm59.fastfood.client.gui.inventory.GuiGrinder;
import danielm59.fastfood.inventory.ContainerCounter;
import danielm59.fastfood.inventory.ContainerGrinder;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityCounter;
import danielm59.fastfood.tileentity.TileEntityGrinder;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
		
		if (id == GuiId.COUNTER.ordinal()) {
			
            TileEntityCounter tileEntityCounter = (TileEntityCounter) world.getTileEntity(x, y, z);
            return new ContainerCounter(entityPlayer.inventory, tileEntityCounter);

        }
		
        if (id == GuiId.GRINDER.ordinal()) {
		
        TileEntityGrinder tileEntityGrinder = (TileEntityGrinder) world.getTileEntity(x, y, z);
        return new ContainerGrinder(entityPlayer.inventory, tileEntityGrinder);
        
        }
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world,int x, int y, int z) {
		
		if (id == GuiId.COUNTER.ordinal()) {
			
            TileEntityCounter tileEntityCounter = (TileEntityCounter) world.getTileEntity(x, y, z);
            return new GuiCounter(entityPlayer.inventory, tileEntityCounter);
              
        }
		
		if (id == GuiId.GRINDER.ordinal()) {
			
            TileEntityGrinder tileEntityGrinder = (TileEntityGrinder) world.getTileEntity(x, y, z);
            return new GuiGrinder(entityPlayer.inventory, tileEntityGrinder);
              
        }
		
		return null;
	}

}