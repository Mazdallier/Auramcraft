package com.auramcraft.init;

import net.minecraft.item.Item;
import com.auramcraft.api.Auras;
import com.auramcraft.item.*;
import com.auramcraft.item.tools.*;
import com.auramcraft.reference.Names;
import com.auramcraft.util.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class AuramcraftItems {
	public static final Item fireShard = new FireShard();
	public static final Item earthShard = new EarthShard();
	public static final Item waterShard = new WaterShard();
	public static final Item airShard = new AirShard();
	public static final Item auramShard = new AuramShard();
	public static final Item gemstone = new Gemstone();
	public static final Item sacrificialDagger = new SacrificialDagger();
	public static final Item devToy = new DevToy();
	public static final Item bookOfAura = new BookOfAura();
	public static final Item auraCrystal = new AuraCrystal(25);
	public static final Item allseeingStone = new AllseeingStone();
	public static final Item charmOfAllseeing = new CharmOfAllseeing();
	public static Item auraCrystal1 = new AuraCrystal(500);
	
	public static void init() {
		// Creative use only
		((AuraCrystal) auraCrystal1).getAuraContainer().store(new Object[] {
				Auras.FIRE, 100,
				Auras.EARTH, 100,
				Auras.WATER, 100,
				Auras.AIR, 100,
				Auras.AURAM, 100
		});
		
		GameRegistry.registerItem(fireShard, Names.Items.FIRESHARD);
		GameRegistry.registerItem(earthShard, Names.Items.EARTHSHARD);
		GameRegistry.registerItem(waterShard, Names.Items.WATERSHARD);
		GameRegistry.registerItem(airShard, Names.Items.AIRSHARD);
		GameRegistry.registerItem(auramShard, Names.Items.AURAMSHARD);
		GameRegistry.registerItem(gemstone, Names.Items.GEMSTONE);
		GameRegistry.registerItem(sacrificialDagger, Names.Items.SACRIFICIALDAGGER);
		GameRegistry.registerItem(devToy, Names.Items.DEVTOY);
		GameRegistry.registerItem(bookOfAura, Names.Items.BOOK_OF_AURA);
		GameRegistry.registerItem(auraCrystal, Names.Items.AURACRYSTAL);
		GameRegistry.registerItem(allseeingStone, Names.Items.ALLSEEING_STONE);
		GameRegistry.registerItem(charmOfAllseeing, Names.Items.CHARM_OF_ALLSEEING);
		
		// Creative only
		GameRegistry.registerItem(auraCrystal1, Names.Items.AURACRYSTAL + "1");
		
		LogHelper.info("Initialized Items");
	}
}
