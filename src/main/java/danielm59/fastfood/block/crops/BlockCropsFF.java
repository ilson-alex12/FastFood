package danielm59.fastfood.block.crops;


import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danielm59.fastfood.init.ModBlocks;
import danielm59.fastfood.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropsFF extends BlockCrops implements IGrowable {
	
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
    private Item seed;
    private Item drop;

    public BlockCropsFF() {

        this.setTickRandomly(true);
        this.setCreativeTab((CreativeTabs) null);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
        this.disableStats();
        this.setBlockTextureName(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    public static boolean func_149887_c(int meta) {

        return (meta & 7) != 0;
    }

    @Override
    public String getUnlocalizedName() {

        return String.format("tile.%s:%s", Reference.MODID, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String name) {

        return name.substring(name.indexOf(".") + 1);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {

        int l = world.getBlockMetadata(x, y, z);
        if (l <= 2) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
        } else if (l <= 4) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        } else if (l <= 6) {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        } else {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {

        if (world.getBlock(x, y, z) instanceof BlockCropsFF) {
            if (world.getBlockMetadata(x, y, z) == 8) {
                world.setBlockMetadataWithNotify(x, y - 1, z, 5, 2);
            }
        }
    }

    public void fertilize(World world, int x, int y, int z) {

        int meta = world.getBlockMetadata(x, y, z);
        if (meta < 7) {
            meta = meta + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);
            if (meta > 6) {
                world.setBlockMetadataWithNotify(x, y, z, 7, 2);
            } else {
                world.setBlockMetadataWithNotify(x, y, z, meta, 2);
            }
        }
    }

    /**
     * is the block grass, dirt or farmland
     */
    @Override
    protected boolean canPlaceBlockOn(Block block) {

        return block == Blocks.farmland;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {

        super.updateTick(world, x, y, z, random);

        if (world.getBlockLightValue(x, y + 1, z) >= 9) {
            int meta = world.getBlockMetadata(x, y, z);
            if ((meta == 4) || (meta == 5)) {
                return;
            }
            if (random.nextInt(45) == 0) {
                world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
            }
            if ((meta > 6) && (world.getBlock(x, y - 1, z) instanceof BlockFarmland)) {
                world.setBlockMetadataWithNotify(x, y, z, 7, 2);
            }
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {

        if (meta < 0 || meta > 7) {
            meta = 7;
        }

        return this.iconArray[meta];
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType() {

        return 6;
    }

    @Override
    protected Item func_149866_i() {

        return seed;
    }

    @Override
    protected Item func_149865_P() {

        return drop;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    @Override
    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int p_149690_5_, float p_149690_6_, int p_149690_7_) {

        super.dropBlockAsItemWithChance(world, x, y, z, p_149690_5_, p_149690_6_, 0);
    }

    @Override
    public Item getItemDropped(int meta, Random random, int p_149650_3_) {

        return meta == 7 ? this.func_149865_P() : this.func_149866_i();
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random random) {

        return random.nextInt(3) + 1;
    }

    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean p_149851_5_) {

        return world.getBlockMetadata(x, y, z) != 7;
    }

    @Override
    public boolean func_149852_a(World world, Random random, int x, int y, int z) {

        return true;
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    @Override
    public Item getItem(World world, int x, int y, int z) {

        return this.func_149866_i();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {

        this.iconArray = new IIcon[8];

        for (int i = 0; i < this.iconArray.length; ++i) {
            int tex = 0;
            if (i == 0 || i == 1) {
                tex = 0;
            } else if (i == 2) {
                tex = 1;
            } else if (i == 3 || i == 4) {
                tex = 2;
            } else if ((i == 5) || (i == 6)) {
                tex = 3;
            } else if (i == 7) {
                tex = 4;
            }

            this.iconArray[i] = iconRegister.registerIcon(this.getTextureName() + "_stage_" + tex);
        }
    }

    @Override
    public void func_149853_b(World world, Random random, int x, int y, int z) {

        this.fertilize(world, x, y, z);
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {

        ArrayList<ItemStack> ret = super.getDrops(world, x, y, z, metadata, fortune);

        return ret;
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {

        return super.canPlaceBlockAt(world, x, y, z) && world.isAirBlock(x, y + 1, z);
    }

    /**
     * checks if the block can stay, if not drop as item
     */
    @Override
    protected void checkAndDropBlock(World world, int x, int y, int z) {

        if (!this.canBlockStay(world, x, y, z)) {
            int l = world.getBlockMetadata(x, y, z);
            this.dropBlockAsItem(world, x, y, z, l, 0);
            world.setBlock(x, y, z, Blocks.air, 0, 2);
        }
    }

    /**
     * Can this block stay at this position. Similar to canPlaceBlockAt except gets checked often with plants.
     */
    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {

        if (world.getBlock(x, y, z) != this) return super.canBlockStay(world, x, y, z);
        return (world.getBlock(x, y - 1, z) instanceof BlockFarmland) || (world.getBlock(x, y - 1, z) instanceof BlockCropsFF);
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
    	return EnumPlantType.Crop;
    }
    
    public void setSeed(Item seed) {
    	
    	this.seed = seed;
    	
    }
    
    public void setDrop(Item drop) {
    	
    	this.drop = drop;
    	
    }
    
}
