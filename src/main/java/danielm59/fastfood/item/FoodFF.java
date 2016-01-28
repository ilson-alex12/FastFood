package danielm59.fastfood.item;

import java.util.Random;

import danielm59.fastfood.creativetab.CreativeTabFF;
import danielm59.fastfood.reference.Reference;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class FoodFF extends ItemFood
{
    
    public FoodFF(int hunger, float saturation, boolean wolf)
    {
        
        super(hunger, saturation, wolf);
        this.setCreativeTab(CreativeTabFF.FF_TAB);
    }
    
    @Override
    public String getUnlocalizedName()
    {
        
        return String.format("item.%s:%s", Reference.MODID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        
        return String.format("item.%s:%s", Reference.MODID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        
        if (stack.getItem().hasContainerItem(stack))
        {
            
            if (!playerIn.inventory.addItemStackToInventory(new ItemStack(stack.getItem().getContainerItem(), 1)))
            {
                
                if (!worldIn.isRemote)
                {
                    
                    Random rand = new Random();
                    BlockPos p = playerIn.getPosition();
                    
                    float x = p.getX();
                    float y = p.getY() + 1;
                    float z = p.getZ();
                    
                    float dX = rand.nextFloat() * 0.8F + 0.1F;
                    float dY = rand.nextFloat() * 0.8F + 0.1F;
                    float dZ = rand.nextFloat() * 0.8F + 0.1F;
                    
                    EntityItem entityItem = new EntityItem(worldIn, x + dX, y + dY, z + dZ, new ItemStack(stack.getItem().getContainerItem(), 1));
                    
                    if (stack.hasTagCompound())
                    {
                        
                        entityItem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
                        
                    }
                    
                    float factor = 0.05F;
                    entityItem.motionX = rand.nextGaussian() * factor;
                    entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                    entityItem.motionZ = rand.nextGaussian() * factor;
                    
                    worldIn.spawnEntityInWorld(entityItem);
                    
                }
                
            }
            
        }
        
        return super.onItemUseFinish(stack, worldIn, playerIn);
        
    }
}
