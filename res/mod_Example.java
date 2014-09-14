package net.minecraft.src;

public class mod_$ extends BaseMod
{

	public static final Block $ = new Block$($, 0).setHardness($F).setResistance($F).setBlockName("$");
	
        public mod_$()
        {
                 ModLoader.RegisterBlock($);
                 $.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "$");
                 ModLoader.AddName($, "$");
        }

	public String Version()
	{
		return "1.5_01";
	}

}