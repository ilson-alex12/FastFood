package danielm59.fastfood.client.gui.inventory;

import org.lwjgl.opengl.GL11;

import danielm59.fastfood.inventory.ContainerPress;
import danielm59.fastfood.reference.Reference;
import danielm59.fastfood.tileentity.TileEntityPress;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiPress extends GuiContainer
{
    
    private TileEntityPress tileEntityPress;
    
    public GuiPress(InventoryPlayer inventory, TileEntityPress Press, EntityPlayer player)
    {
        
        super(new ContainerPress(inventory, Press, player));
        tileEntityPress = Press;
        xSize = 176;
        ySize = 166;
        
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        
        fontRendererObj.drawString(StatCollector.translateToLocal(tileEntityPress.getName()), 8, 6, 4210752);
        
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID.toLowerCase(), "textures/gui/2to1Gui.png"));
        
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        
        int processPogress = (int) (tileEntityPress.getProgress() * 22);
        drawTexturedModalRect(xStart + 80, yStart + 35, 176, 0, processPogress, 15);
        
    }
}
