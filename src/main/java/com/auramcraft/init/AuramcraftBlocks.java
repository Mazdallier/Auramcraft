package com.auramcraft.init;

import net.minecraft.block.Block;
import com.auramcraft.block.*;
import com.auramcraft.reference.Names;
import com.auramcraft.util.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class AuramcraftBlocks {
	public static final Block gemstoneOre = new GemstoneOre();
	public static final Block infusionTable = new InfusionTable();
	
	public static void init() {
		GameRegistry.registerBlock(gemstoneOre, Names.Blocks.GEMSTONEORE);
		GameRegistry.registerBlock(infusionTable, Names.Blocks.INFUSIONTABLE);
		
		LogHelper.info("Initialized Blocks");
	}
}