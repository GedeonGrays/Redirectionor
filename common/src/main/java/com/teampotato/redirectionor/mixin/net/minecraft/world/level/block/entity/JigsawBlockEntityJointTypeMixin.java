package com.teampotato.redirectionor.mixin.net.minecraft.world.level.block.entity;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.entity.JigsawBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import java.util.Map;
import java.util.Optional;

@Mixin(JigsawBlockEntity.JointType.class)
public abstract class JigsawBlockEntityJointTypeMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static Optional<JigsawBlockEntity.JointType> byName(String name) {
        return Optional.ofNullable(JOINT_TYPE_NAME_MAP.get(name));
    }

    @Unique
    private static final Map<String, JigsawBlockEntity.JointType> JOINT_TYPE_NAME_MAP = new Object2ObjectOpenHashMap<>();

    static {
        JOINT_TYPE_NAME_MAP.put("rollable", JigsawBlockEntity.JointType.ROLLABLE);
        JOINT_TYPE_NAME_MAP.put("aligned", JigsawBlockEntity.JointType.ALIGNED);
    }
}
