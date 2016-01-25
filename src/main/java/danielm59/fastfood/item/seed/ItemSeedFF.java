package danielm59.fastfood.item.seed;

import danielm59.fastfood.creativetab.CreativeTabFF;
import danielm59.fastfood.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemSeedFF extends ItemSeeds implements IPlantable
{
    
    public static Block crop;
    
    public ItemSeedFF(Block blockCrop, Block blockSoil)
    {
        
        super(blockCrop, blockSoil);
        crop = blockCrop;
        this.setCreativeTab(CreativeTabFF.FF_TAB);
        
    }
    
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos p)
    {
        
        return EnumPlantType.Crop;
    }
    
    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos p)
    {
        
        return crop.getDefaultState();
    }
    
    @Override
    public String getUnlocalizedName()
    {
        
        return String.format("item.%s%s", Reference.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        
        return String.format("item.%s%s", Reference.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
