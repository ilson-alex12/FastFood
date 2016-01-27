package io.github.danielm59.fastfood.handler;

import io.github.danielm59.fastfood.client.gui.inventory.GuiChurn;
import io.github.danielm59.fastfood.client.gui.inventory.GuiCounter;
import io.github.danielm59.fastfood.client.gui.inventory.GuiFryer;
import io.github.danielm59.fastfood.client.gui.inventory.GuiGrinder;
import io.github.danielm59.fastfood.client.gui.inventory.GuiMill;
import io.github.danielm59.fastfood.client.gui.inventory.GuiPress;
import io.github.danielm59.fastfood.inventory.ContainerChurn;
import io.github.danielm59.fastfood.inventory.ContainerCounter;
import io.github.danielm59.fastfood.inventory.ContainerFryer;
import io.github.danielm59.fastfood.inventory.ContainerGrinder;
import io.github.danielm59.fastfood.inventory.ContainerMill;
import io.github.danielm59.fastfood.inventory.ContainerPress;
import io.github.danielm59.fastfood.reference.GuiId;
import io.github.danielm59.fastfood.tileentity.TileEntityChurn;
import io.github.danielm59.fastfood.tileentity.TileEntityCounter;
import io.github.danielm59.fastfood.tileentity.TileEntityFryer;
import io.github.danielm59.fastfood.tileentity.TileEntityGrinder;
import io.github.danielm59.fastfood.tileentity.TileEntityMill;
import io.github.danielm59.fastfood.tileentity.TileEntityPress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    
    @Override
    public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        
        if (id == GuiId.COUNTER.ordinal())
        {
            
            TileEntityCounter tileEntityCounter = (TileEntityCounter) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerCounter(entityPlayer.inventory, tileEntityCounter, entityPlayer);
            
        }
        
        if (id == GuiId.GRINDER.ordinal())
        {
            
            TileEntityGrinder tileEntityGrinder = (TileEntityGrinder) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerGrinder(entityPlayer.inventory, tileEntityGrinder, entityPlayer);
            
        }
        
        if (id == GuiId.CHURN.ordinal())
        {
            
            TileEntityChurn tileEntityChurn = (TileEntityChurn) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerChurn(entityPlayer.inventory, tileEntityChurn, entityPlayer);
            
        }
        
        if (id == GuiId.PRESS.ordinal())
        {
            
            TileEntityPress tileEntityPress = (TileEntityPress) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerPress(entityPlayer.inventory, tileEntityPress, entityPlayer);
            
        }
        
        if (id == GuiId.MILL.ordinal())
        {
            
            TileEntityMill tileEntityMill = (TileEntityMill) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerMill(entityPlayer.inventory, tileEntityMill, entityPlayer);
            
        }
        
        if (id == GuiId.FRYER.ordinal())
        {
            
            TileEntityFryer tileEntityFryer = (TileEntityFryer) world.getTileEntity(new BlockPos(x, y, z));
            return new ContainerFryer(entityPlayer.inventory, tileEntityFryer, entityPlayer);
            
        }
        
        return null;
    }
    
    @Override
    public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        
        if (id == GuiId.COUNTER.ordinal())
        {
            
            TileEntityCounter tileEntityCounter = (TileEntityCounter) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiCounter(entityPlayer.inventory, tileEntityCounter, entityPlayer);
            
        }
        
        if (id == GuiId.GRINDER.ordinal())
        {
            
            TileEntityGrinder tileEntityGrinder = (TileEntityGrinder) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiGrinder(entityPlayer.inventory, tileEntityGrinder, entityPlayer);
            
        }
        
        if (id == GuiId.CHURN.ordinal())
        {
            
            TileEntityChurn tileEntityChurn = (TileEntityChurn) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiChurn(entityPlayer.inventory, tileEntityChurn, entityPlayer);
            
        }
        
        if (id == GuiId.PRESS.ordinal())
        {
            
            TileEntityPress tileEntityPress = (TileEntityPress) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiPress(entityPlayer.inventory, tileEntityPress, entityPlayer);
            
        }
        
        if (id == GuiId.MILL.ordinal())
        {
            
            TileEntityMill tileEntityMill = (TileEntityMill) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiMill(entityPlayer.inventory, tileEntityMill, entityPlayer);
            
        }
        
        if (id == GuiId.FRYER.ordinal())
        {
            
            TileEntityFryer tileEntityFryer = (TileEntityFryer) world.getTileEntity(new BlockPos(x, y, z));
            return new GuiFryer(entityPlayer.inventory, tileEntityFryer, entityPlayer);
            
        }
        
        return null;
    }
    
}
