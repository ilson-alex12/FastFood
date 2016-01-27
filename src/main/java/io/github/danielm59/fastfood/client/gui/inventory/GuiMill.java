package io.github.danielm59.fastfood.client.gui.inventory;

import org.lwjgl.opengl.GL11;

import io.github.danielm59.fastfood.inventory.ContainerMill;
import io.github.danielm59.fastfood.reference.Reference;
import io.github.danielm59.fastfood.tileentity.TileEntityMill;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiMill extends GuiContainer
{
    
    private TileEntityMill tileEntityMill;
    
    public GuiMill(InventoryPlayer inventory, TileEntityMill Mill, EntityPlayer player)
    {
        
        super(new ContainerMill(inventory, Mill, player));
        tileEntityMill = Mill;
        xSize = 176;
        ySize = 166;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        
        fontRendererObj.drawString(StatCollector.translateToLocal(tileEntityMill.getName()), 8, 6, 4210752);
        
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID.toLowerCase(), "textures/gui/Mill.png"));
        
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        
        int processOutputPogress = (int) (tileEntityMill.getOutputProgress() * 23);
        drawTexturedModalRect(xStart + 109, yStart + 47, 176, 0, processOutputPogress, 15);
        
        int processInputPogress = (int) (tileEntityMill.getInputProgress() * 51);
        drawTexturedModalRect(xStart + 151 - processInputPogress, yStart + 16, 228 - processInputPogress, 16, processInputPogress, 22);
        
        int flourLevel = (int) (tileEntityMill.getFlourLevel() * 62);
        drawTexturedModalRect(xStart + 10, yStart + 77 - flourLevel, 176, 100 - flourLevel, 67, flourLevel);
    }
    
}
