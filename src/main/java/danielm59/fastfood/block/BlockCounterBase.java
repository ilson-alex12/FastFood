package danielm59.fastfood.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockCounterBase extends BlockFF implements ITileEntityProvider
{
    
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    
    public BlockCounterBase()
    {
        
        super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        
    }
    
    public void onBlockAdded(World worldIn, BlockPos p, IBlockState state)
    {
        
        if (!worldIn.isRemote)
        {
            Block block = worldIn.getBlockState(p.offsetNorth()).getBlock();
            Block block1 = worldIn.getBlockState(p.offsetSouth()).getBlock();
            Block block2 = worldIn.getBlockState(p.offsetWest()).getBlock();
            Block block3 = worldIn.getBlockState(p.offsetEast()).getBlock();
            EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
            
            if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            } else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            } else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            } else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }
            
            worldIn.setBlockState(p, state.withProperty(FACING, enumfacing), 2);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
        
        EnumFacing enumfacing = EnumFacing.getFront(meta);
        
        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }
        
        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
    
    public int getMetaFromState(IBlockState state)
    {
        
        return ((EnumFacing) state.getValue(FACING)).getIndex();
    }
    
    protected BlockState createBlockState()
    {
        
        return new BlockState(this, new IProperty[]
        { FACING });
    }
    
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        
        return this.getDefaultState().withProperty(FACING, placer.func_174811_aO().getOpposite());
    }
    
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.func_174811_aO().getOpposite()), 2);
        
    }
    
}
