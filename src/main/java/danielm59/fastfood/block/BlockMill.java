package danielm59.fastfood.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import danielm59.fastfood.FastFood;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityMill;

public class BlockMill extends BlockCounterBase {
    
    public BlockMill() {
    
        super();
        this.setUnlocalizedName("mill");
    }
    
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
    
        return new TileEntityMill();
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos p, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY,
            float hitZ) {
    
        if (player.isSneaking()) {
            return true;
        } else {
            if (!world.isRemote && world.getTileEntity(p) instanceof TileEntityMill) {
                player.openGui(FastFood.instance, GuiId.MILL.ordinal(), world, p.getX(), p.getY(), p.getZ());
            }
            
            return true;
        }
    }
    
}
