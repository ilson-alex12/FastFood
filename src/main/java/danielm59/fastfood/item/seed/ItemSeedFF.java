package danielm59.fastfood.item.seed;

import danielm59.fastfood.creativetab.CreativeTabFF;
import danielm59.fastfood.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemSeedFF extends ItemSeeds implements IPlantable {

	public static Block crop;
	
	public ItemSeedFF(Block blockCrop, Block blockSoil) {
		super(blockCrop, blockSoil);
		crop = blockCrop;
        this.setCreativeTab(CreativeTabFF.FF_TAB);
        this.setTextureName(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
		
	}

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if (side != 1) {
            return false;
        } else if (player.canPlayerEdit(x, y, z, side, itemStack) && player.canPlayerEdit(x, y + 1, z, side, itemStack)) {
            if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && world.isAirBlock(x, y + 1, z)
                    && (world.getBlock(x, y, z).isFertile(world, x, y, z))) {
                world.setBlock(x, y + 1, z, crop, 0, 2);
                --itemStack.stackSize;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {

        return EnumPlantType.Crop;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z) {

        return crop;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {

        return 0;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return String.format("item.%s:%s", Reference.MODID, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String name) {

        return name.substring(name.indexOf(".") + 1);
    }
    
}
