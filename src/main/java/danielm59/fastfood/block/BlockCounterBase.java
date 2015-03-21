package danielm59.fastfood.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danielm59.fastfood.reference.Reference;

public abstract class BlockCounterBase extends BlockFF implements ITileEntityProvider {

	protected IIcon blockIconTop;
	protected IIcon blockIconBot;
	protected IIcon blockIconFront;
	
   public BlockCounterBase() {
	   
	   super();
	   this.setBlockTextureName((String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "_front")));
	   
   }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
    	
    	blockIcon = iconRegister.registerIcon(Reference.MODID + ":counter_side");
    	blockIconTop = iconRegister.registerIcon(Reference.MODID + ":counter_top");
    	blockIconBot = iconRegister.registerIcon(Reference.MODID + ":counter_bottom");
    	blockIconFront = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "_front"));
    	
    }
	
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack iStack) {
    	
    	int front = MathHelper.floor_double(player.rotationYaw / 90F + 0.5D) & 3;
    	
    	int meta = 2;
        switch (front) {
            case 0:
                meta = 2;
                break;
            case 1:
                meta = 5;
                break;
            case 2:
                meta = 3;
                break;
            case 3:
                meta = 4;
                break;
        }
        
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
        
    }

    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
    
        ForgeDirection s = ForgeDirection.getOrientation(side);
        
        if (meta == side) {
        	
        	return blockIconFront;
        	
        }
        
        switch (s) {
        
            case UP:
                return blockIconTop;
                
            case DOWN:
                return blockIconBot;
                
            case EAST:
            case NORTH:
            case SOUTH:
            case WEST:
            case UNKNOWN:
                return blockIcon;
                
            default:
                break;
        
        }
        
        return null;
    }
	
}