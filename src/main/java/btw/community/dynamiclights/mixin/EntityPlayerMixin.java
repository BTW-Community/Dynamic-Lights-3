package btw.community.dynamiclights.mixin;

import btw.community.dynamiclights.DynamicLightSourceBlock;
import btw.community.dynamiclights.DynamicLightsAddon;
import btw.community.dynamiclights.LightSourceCarrier;
import api.world.BlockPos;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayer.class)
public abstract class EntityPlayerMixin implements LightSourceCarrier {


	@Unique
	private boolean hasLightSource = false;
	@Unique
	private int lightSourceUpdateTimer = 0;

	@Unique
	public boolean dynamicLights$getHasLightSource() {
		return hasLightSource;
	}

	@Inject(at = @At("RETURN"), method = "onUpdate", remap = true)
	private void onUpdateMixin(CallbackInfo info) {
		EntityPlayer player = (EntityPlayer) (Object) this;

		if (!player.worldObj.isRemote)
		{
			lightSourceUpdateTimer++;
			if (hasLightSource || lightSourceUpdateTimer >9)
			{
				ItemStack heldItem = player.getHeldItem();
				lightSourceUpdateTimer =0;

                hasLightSource = heldItem != null && DynamicLightsAddon.lightEmittingItems.contains(heldItem.itemID);;

				if (hasLightSource)
				{
					BlockPos lightPos = new BlockPos(MathHelper.floor_double( player.posX ),
							MathHelper.floor_double(player.boundingBox.maxY), MathHelper.floor_double( player.posZ));
					if (player.worldObj.getBlockId(lightPos.x, lightPos.y, lightPos.z)==0)
					{
						player.worldObj.setBlock(lightPos.x, lightPos.y, lightPos.z, DynamicLightsAddon.lightSource.blockID,0 ,2);
						player.worldObj.scheduleBlockUpdate(lightPos.x, lightPos.y, lightPos.z, DynamicLightsAddon.lightSource.blockID, DynamicLightSourceBlock.LIGHT_SOURCE_TICK_RATE);
					}
				}
			}
		}
	}
}

