package barryflash.superheroes.worldgen;

import java.util.Random;

import barryflash.superheroes.blocks.BlockAmazonianOre;
import barryflash.superheroes.init.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {
	//World Generators
	private WorldGenerator amazonian_ore;
	private WorldGenerator copper_ore;
	
	public OreGen() {
		//amazonian_ore = new WorldGenMinable(ModBlocks.amazonian_ore.getDefaultState(), 2);
		//copper_ore = new WorldGenMinable(ModBlocks.copper_ore.getDefaultState(), 2);
	}
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i ++) {
			int x = chunk_X * 16 + rand.nextInt(16);
		        int y = minHeight + rand.nextInt(heightDiff);
		        int z = chunk_Z * 16 + rand.nextInt(16);
		        generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
			this.runGenerator(amazonian_ore, world, random, chunkX, chunkZ, 10, 2, 30);
			this.runGenerator(copper_ore, world, random, chunkX, chunkZ, 30, 10, 50);
		
		}
		
	}


