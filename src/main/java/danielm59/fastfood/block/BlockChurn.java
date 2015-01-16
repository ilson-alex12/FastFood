package danielm59.fastfood.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import danielm59.fastfood.FastFood;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityChurn;

public class BlockChurn extends BlockCounterBase {

	public BlockChurn(){
		
		super();
		this.setUnlocalizedName("churn");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityChurn();
	}

    @Override
    public boolean onBlockActivated(World world, BlockPos p, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (player.isSneaking() || world.isSideSolid(p.add(0, 1, 0), EnumFacing.DOWN))
        {
            return true;
        }
        else
        {
            if (!world.isRemote && world.getTileEntity(p) instanceof TileEntityChurn)
            {
                player.openGui(FastFood.instance, GuiId.CHURN.ordinal(), world, p.getX(), p.getY(), p.getZ());
            }

            return true;
        }
    } 
    
}