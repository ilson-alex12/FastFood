package danielm59.fastfood.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import danielm59.fastfood.FastFood;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityChurn;

public class BlockChurn extends BlockCounterBase {

	public BlockChurn(){
		
		super();
		this.setBlockName("churn");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityChurn();
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
            if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityChurn)
            {
                player.openGui(FastFood.instance, GuiId.CHURN.ordinal(), world, x, y, z);
            }

            return true;
        }
    } 
    
}
