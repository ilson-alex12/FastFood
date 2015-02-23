package danielm59.fastfood.proxy;

import danielm59.fastfood.init.*;

public class ClientProxy extends CommonProxy{

	@Override
	public void loadTextures() {
    	
		ModBlocks.textures();
    	ModItems.textures();
    	ModFood.textures();
    	ModCrops.textures();
    	
	}	
	
}
