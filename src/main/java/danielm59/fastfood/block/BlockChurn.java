package danielm59.fastfood.block;

import danielm59.fastfood.FastFood;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityChurn;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;



public class BlockChurn extends BlockCounterBase {

	public static final PropertyBool ON = PropertyBool.create("on");

	public BlockChurn(){
		
		super();
		this.setUnlocalizedName("churn");
		this.setDefaultState(this.blockState.getBaseState().withProperty(ON, Boolean.valueOf(false)).withProperty(FACING, EnumFacing.NORTH));
		
	}
	
	 public IBlockState getActualState(final IBlockState state, final IBlockAccess worldIn, final BlockPos pos) {
		 boolean active = false;
		if (worldIn.getTileEntity(pos) instanceof TileEntityChurn){
			active = ((TileEntityChurn) worldIn.getTileEntity(pos)).isActive();
		}
		  return state.withProperty(FACING, state.getValue(FACING)).withProperty(ON, active);
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
    
    protected BlockState createBlockState(){
        return new BlockState(this, new IProperty[] {FACING, ON});
    }
    
	@Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta) {
    	EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
    
}
