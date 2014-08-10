package danielm59.fastfood.block;

import danielm59.fastfood.FastFood;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockGrinder extends BlockCounterBase{

public BlockGrinder(){
		
		super();
		this.setBlockName("grinder");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityGrinder();
	}

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking() || world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN))
        {
            return true;
        }
        else
        {
            if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityGrinder)
            {
                player.openGui(FastFood.instance, GuiId.GRINDER.ordinal(), world, x, y, z);
            }

            return true;
        }
    } 
    
    @Override
    public boolean onBlockEventReceived(World world, int x, int y, int z, int eventId, int eventData)
    {
        super.onBlockEventReceived(world, x, y, z, eventId, eventData);
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null && tileentity.receiveClientEvent(eventId, eventData);
    }
	
}
