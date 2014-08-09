package danielm59.fastfood.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly; 
import danielm59.fastfood.FastFood;
import danielm59.fastfood.reference.GuiId;
import danielm59.fastfood.tileentity.TileEntityCounter;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class BlockCounter extends BlockCounterBase{

	
	public BlockCounter(){
		
		super();
		this.setBlockName("counter");
		
	}
	
	 @Override
	    public TileEntity createNewTileEntity(World world, int metaData)
	    {
	        
	            return new TileEntityCounter();
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
	            if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityCounter)
	            {
	                player.openGui(FastFood.instance, GuiId.COUNTER.ordinal(), world, x, y, z);
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
