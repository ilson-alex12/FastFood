package danielm59.fastfood.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import danielm59.fastfood.inventory.ContainerFryer;
import danielm59.fastfood.tileentity.TileEntityFryer;

public class GuiFryer extends GuiContainer {
    
    private TileEntityFryer tileEntityFryer;
    
    public GuiFryer(InventoryPlayer inventory, TileEntityFryer Fryer, EntityPlayer player) {
    
        super(new ContainerFryer(inventory, Fryer, player));
        tileEntityFryer = Fryer;
        xSize = 175; // TODO Add Fryer GUI size
        ySize = 165;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
    
        fontRendererObj.drawString(StatCollector.translateToLocal(tileEntityFryer.getName()), 8, 6, 4210752);
        
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    
        // TODO Add code to draw GUI screen
        
    }
    
}
