package com.auramcraft.item;

import com.auramcraft.Auramcraft;
import com.auramcraft.api.Auras;
import com.auramcraft.reference.Names;
import com.auramcraft.reference.Reference;
import com.auramcraft.reference.Textures;

public class WaterShard extends Shard {
	public WaterShard() {
		super(Auras.WATER);
		setUnlocalizedName(Names.Items.WATERSHARD);
		setTextureName(Textures.Items.ITEM_WATER_SHARD);
	}
}
