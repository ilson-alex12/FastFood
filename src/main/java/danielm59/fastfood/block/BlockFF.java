package danielm59.fastfood.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import danielm59.fastfood.creativetab.CreativeTabFF;
import danielm59.fastfood.reference.Reference;

public abstract class BlockFF extends Block {
    
    public BlockFF(Material material) {
    
        super(material);
        this.setCreativeTab(CreativeTabFF.FF_TAB);
        this.setHardness(3.0F);
        
    }
    
    public BlockFF() {
    
        this(Material.rock);
        
    }
    
    @Override
    public String getUnlocalizedName() {
    
        return String.format("tile.%s:%s", Reference.MODID.toLowerCase(), getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    protected String getUnwrappedUnlocalizedName(String name) {
    
        return name.substring(name.indexOf(".") + 1);
    }
    
    @Override
    public void breakBlock(World world, BlockPos p, IBlockState state) {
    
        dropInventory(world, p);
        super.breakBlock(world, p, state);
    }
    
    protected void dropInventory(World world, BlockPos p) {
    
        TileEntity tileEntity = world.getTileEntity(p);
        
        if (!(tileEntity instanceof IInventory)) { return; }
        
        IInventory inventory = (IInventory) tileEntity;
        
        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            
            if (itemStack != null && itemStack.stackSize > 0) {
                Random rand = new Random();
                
                float x = p.getX();
                float y = p.getY();
                float z = p.getZ();
                
                float dX = rand.nextFloat() * 0.8F + 0.1F;
                float dY = rand.nextFloat() * 0.8F + 0.1F;
                float dZ = rand.nextFloat() * 0.8F + 0.1F;
                
                EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ, itemStack.copy());
                
                if (itemStack.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
                }
                
                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                itemStack.stackSize = 0;
            }
        }
    }
}
