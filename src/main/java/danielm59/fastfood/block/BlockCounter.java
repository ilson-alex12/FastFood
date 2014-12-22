package danielm59.fastfood.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly; 
import danielm59.fastfood.FastFood;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityCounter;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class BlockCounter extends BlockCounterBase{

	
	public BlockCounter(){
		
		super();
		this.setUnlocalizedName("counter");
		
	}
	
	 @Override
	    public TileEntity createNewTileEntity(World world, int metaData)
	    {
	        
	            return new TileEntityCounter();
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
	            if (!world.isRemote && world.getTileEntity(p) instanceof TileEntityCounter)
	            {
	                player.openGui(FastFood.instance, GuiId.COUNTER.ordinal(), world, p.getX(), p.getY(), p.getZ());
	            }

	            return true;
	        }
	    } 
	
}
