package danielm59.fastfood.client.gui.inventory;

import org.lwjgl.opengl.GL11;

import danielm59.fastfood.inventory.ContainerFryer;
import danielm59.fastfood.reference.Reference;
import danielm59.fastfood.tileentity.TileEntityFryer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiFryer extends GuiContainer
{
    
    private TileEntityFryer tileEntityFryer;
    
    public GuiFryer(InventoryPlayer inventory, TileEntityFryer Fryer, EntityPlayer player)
    {
        
        super(new ContainerFryer(inventory, Fryer, player));
        tileEntityFryer = Fryer;
        xSize = 176;
        ySize = 166;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        
        fontRendererObj.drawString(StatCollector.translateToLocal(tileEntityFryer.getName()), 24, 6, 4210752);
        
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID.toLowerCase(), "textures/gui/fryer.png"));
        
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
        
        int oilProgress = (int) (tileEntityFryer.getOilProgress() * 14);
        drawTexturedModalRect(xStart + 28, yStart + 36, 176, 31, 12, oilProgress);
        
        int oilLevel = (int) (tileEntityFryer.getOilLevel() * 72);
        drawTexturedModalRect(xStart + 8, yStart + 7 + (72 - oilLevel), 176, 45 + (72 - oilLevel), 12, oilLevel);
        
        int fryerProgress = (int) (tileEntityFryer.getFryerProgress() * 24);
        drawTexturedModalRect(xStart + 85, yStart + 34, 176, 14, fryerProgress, 17);
        
        int heatLevel = (int) (tileEntityFryer.getHeat() * 72);
        drawTexturedModalRect(xStart + 156, yStart + 7 + (72 - heatLevel), 188, 45 + (72 - heatLevel), 12, heatLevel);
        
        int burnProgress = (int) (tileEntityFryer.getBurnProgress() * 14);
        drawTexturedModalRect(xStart + 62, yStart + 36 + (14 - burnProgress), 176, 14 - burnProgress, 14, burnProgress);
        
    }
    
}
