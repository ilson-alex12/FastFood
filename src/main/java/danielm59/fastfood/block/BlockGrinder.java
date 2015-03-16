package danielm59.fastfood.block;

import danielm59.fastfood.FastFood;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityGrinder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockGrinder extends BlockCounterBase{

	public BlockGrinder(){
		
		super();
		this.setUnlocalizedName("grinder");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityGrinder();
	}

    @Override
    public boolean onBlockActivated(World world, BlockPos p, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (player.isSneaking())
        {
            return true;
        }
        else
        {
            if (!world.isRemote && world.getTileEntity(p) instanceof TileEntityGrinder)
            {
                player.openGui(FastFood.instance, GuiId.GRINDER.ordinal(), world, p.getX(), p.getY(), p.getZ());
            }

            return true;
        }
    } 
    
}
