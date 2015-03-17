package danielm59.fastfood.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import danielm59.fastfood.client.gui.inventory.GuiChurn;
import danielm59.fastfood.client.gui.inventory.GuiCounter;
import danielm59.fastfood.client.gui.inventory.GuiGrinder;
import danielm59.fastfood.client.gui.inventory.GuiMill;
import danielm59.fastfood.client.gui.inventory.GuiPress;
import danielm59.fastfood.inventory.ContainerChurn;
import danielm59.fastfood.inventory.ContainerCounter;
import danielm59.fastfood.inventory.ContainerGrinder;
import danielm59.fastfood.inventory.ContainerMill;
import danielm59.fastfood.inventory.ContainerPress;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityChurn;
import danielm59.fastfood.tileentity.TileEntityCounter;
import danielm59.fastfood.tileentity.TileEntityGrinder;
import danielm59.fastfood.tileentity.TileEntityMill;
import danielm59.fastfood.tileentity.TileEntityPress;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
		
		if (id == GuiId.COUNTER.ordinal()) {
			
            TileEntityCounter tileEntityCounter = (TileEntityCounter) world.getTileEntity(x, y, z);
            return new ContainerCounter(entityPlayer.inventory, tileEntityCounter, entityPlayer);

        }
		
        if (id == GuiId.GRINDER.ordinal()) {
		
        	TileEntityGrinder tileEntityGrinder = (TileEntityGrinder) world.getTileEntity(x, y, z);
        	return new ContainerGrinder(entityPlayer.inventory, tileEntityGrinder, entityPlayer);
        
        }
        
        if (id == GuiId.CHURN.ordinal()) {
    		
        	TileEntityChurn tileEntityChurn = (TileEntityChurn) world.getTileEntity(x, y, z);
        	return new ContainerChurn(entityPlayer.inventory, tileEntityChurn, entityPlayer);
            
        }
        
        if (id == GuiId.PRESS.ordinal()) {
    		
        	TileEntityPress tileEntityPress = (TileEntityPress) world.getTileEntity(x, y, z);
        	return new ContainerPress(entityPlayer.inventory, tileEntityPress, entityPlayer);
            
        }
        
        if (id == GuiId.MILL.ordinal()) {
    		
        	TileEntityMill tileEntityMill = (TileEntityMill) world.getTileEntity(x, y, z);
        	return new ContainerMill(entityPlayer.inventory, tileEntityMill, entityPlayer);
            
        }
		
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world,int x, int y, int z) {
		
		if (id == GuiId.COUNTER.ordinal()) {
			
            TileEntityCounter tileEntityCounter = (TileEntityCounter) world.getTileEntity(x, y, z);
            return new GuiCounter(entityPlayer.inventory, tileEntityCounter, entityPlayer);
              
        }
		
		if (id == GuiId.GRINDER.ordinal()) {
			
            TileEntityGrinder tileEntityGrinder = (TileEntityGrinder) world.getTileEntity(x, y, z);
            return new GuiGrinder(entityPlayer.inventory, tileEntityGrinder, entityPlayer);
              
        }

		if (id == GuiId.CHURN.ordinal()) {
			
            TileEntityChurn tileEntityChurn = (TileEntityChurn) world.getTileEntity(x, y, z);
            return new GuiChurn(entityPlayer.inventory, tileEntityChurn, entityPlayer);
              
        }
		
		if (id == GuiId.PRESS.ordinal()) {
			
            TileEntityPress tileEntityPress = (TileEntityPress) world.getTileEntity(x, y, z);
            return new GuiPress(entityPlayer.inventory, tileEntityPress, entityPlayer);
              
        }
		

		if (id == GuiId.MILL.ordinal()) {
			
            TileEntityMill tileEntityMill = (TileEntityMill) world.getTileEntity(x, y, z);
            return new GuiMill(entityPlayer.inventory, tileEntityMill, entityPlayer);
              
        }
		
		return null;
	}

}
