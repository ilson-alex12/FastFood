package danielm59.fastfood.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import danielm59.fastfood.client.gui.inventory.*;
import danielm59.fastfood.inventory.*;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.*;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
		
		if (id == GuiId.COUNTER.ordinal()) {
			
            TileEntityCounter tileEntityCounter = (TileEntityCounter) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerCounter(entityPlayer.inventory, tileEntityCounter, entityPlayer);

        }
		
        if (id == GuiId.GRINDER.ordinal()) {
		
        	TileEntityGrinder tileEntityGrinder = (TileEntityGrinder) world.getTileEntity(new BlockPos(x, y, z));
        	return new ContainerGrinder(entityPlayer.inventory, tileEntityGrinder, entityPlayer);
        
        }
        
        if (id == GuiId.CHURN.ordinal()) {
    		
        	TileEntityChurn tileEntityChurn = (TileEntityChurn) world.getTileEntity(new BlockPos(x, y, z));
        	return new ContainerChurn(entityPlayer.inventory, tileEntityChurn, entityPlayer);
            
        }
        
        if (id == GuiId.PRESS.ordinal()) {
    		
        	TileEntityPress tileEntityChurn = (TileEntityPress) world.getTileEntity(new BlockPos(x, y, z));
        	return new ContainerPress(entityPlayer.inventory, tileEntityChurn, entityPlayer);
            
        }
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world,int x, int y, int z) {
		
		if (id == GuiId.COUNTER.ordinal()) {
			
            TileEntityCounter tileEntityCounter = (TileEntityCounter) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiCounter(entityPlayer.inventory, tileEntityCounter, entityPlayer);
              
        }
		
		if (id == GuiId.GRINDER.ordinal()) {
			
            TileEntityGrinder tileEntityGrinder = (TileEntityGrinder) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiGrinder(entityPlayer.inventory, tileEntityGrinder, entityPlayer);
              
        }

		if (id == GuiId.CHURN.ordinal()) {
			
            TileEntityChurn tileEntityChurn = (TileEntityChurn) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiChurn(entityPlayer.inventory, tileEntityChurn, entityPlayer);
              
        }
		
		if (id == GuiId.PRESS.ordinal()) {
			
            TileEntityPress tileEntityChurn = (TileEntityPress) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiPress(entityPlayer.inventory, tileEntityChurn, entityPlayer);
              
        }
		
		return null;
	}

}
