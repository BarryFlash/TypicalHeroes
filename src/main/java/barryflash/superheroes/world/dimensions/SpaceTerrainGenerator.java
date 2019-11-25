package barryflash.superheroes.world.dimensions;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

public class SpaceTerrainGenerator {
	private World world;
    private Random random;

    private final double[] heightMap;
    private double[] mainNoiseRegion;
    private double[] minLimitRegion;
    private double[] maxLimitRegion;
    private double[] depthRegion;

    private NoiseGeneratorOctaves minLimitPerlinNoise;
    private NoiseGeneratorOctaves maxLimitPerlinNoise;
    private NoiseGeneratorOctaves mainPerlinNoise;
    private NoiseGeneratorPerlin surfaceNoise;

    // A NoiseGeneratorOctaves used in generating terrain
    private NoiseGeneratorOctaves depthNoise;

    private final float[] biomeWeights;
    private double[] depthBuffer = new double[256];

    private Biome[] biomesForGeneration;
    
    public SpaceTerrainGenerator() {
        this.heightMap = new double[825];

        this.biomeWeights = new float[25];
        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k <= 2; ++k) {
                float f = 10.0F / MathHelper.sqrt((j * j + k * k) + 0.2F);
                this.biomeWeights[j + 2 + (k + 2) * 5] = f;
            }
        }
    }

    public void setBiomesForGeneration(Biome[] biomesForGeneration) {
        this.biomesForGeneration = biomesForGeneration;
    }

    public void setup(World world, Random rand) {
        this.world = world;
        this.random = rand;

    
    }


    private void generateHeightmap(int chunkX4, int chunkY4, int chunkZ4) {
       
    }


    public void generate(int chunkX, int chunkZ, ChunkPrimer primer) {
       
    }

 

}
