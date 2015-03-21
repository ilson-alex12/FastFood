package danielm59.fastfood.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import danielm59.fastfood.FastFood;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityPress;

public class BlockPress extends BlockCounterBase {

	public BlockPress(){
		
		super();
		this.setBlockName("press");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int MetaData){
		
		return new TileEntityPress();
		
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            return true;
        }
        else
        {
            if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityPress)
            {
                player.openGui(FastFood.instance, GuiId.PRESS.ordinal(), world, x, y, z);
            }

            return true;
        }
    } 
	
}
