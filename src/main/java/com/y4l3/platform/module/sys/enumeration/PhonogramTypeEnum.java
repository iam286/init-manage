package com.y4l3.platform.module.sys.enumeration;

import com.google.common.collect.ImmutableSet;
import lombok.Getter;

import java.util.Set;

/**
 * @author Kay
 * @version 1.0 2020/2/20
 */
@Getter
public enum PhonogramTypeEnum {
    MONOPHTHONG(1, "单元音"),
    DIPHTHONG(2, "双元音"),
    VOICELESS(3, "清辅音"),
    VOICED(4, "浊辅音");

    private final int code;
    private final String typeName;
    /**
     * 元音
     */
    private static final Set<Integer> VOWELS = ImmutableSet.of(MONOPHTHONG.getCode(), DIPHTHONG.getCode());
    /**
     * 辅音
     */
    private static final Set<Integer> CONSONANTS = ImmutableSet.of(VOICELESS.getCode(), VOICED.getCode());

    PhonogramTypeEnum(int code, String typeName) {
        this.code = code;
        this.typeName = typeName;
    }

    public static boolean isVowels(int code) {
        return VOWELS.contains(code);
    }

    public static boolean isConsonants(int code) { return CONSONANTS.contains(code); }

    public static PhonogramTypeEnum codeOf(int type) {
        for (PhonogramTypeEnum phonogramType : PhonogramTypeEnum.values()) {
            if (phonogramType.getCode() == type) {
                return phonogramType;
            }
        }
        return null;
    }
}
