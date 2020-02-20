package com.y4l3.platform.module.sys.service;

import com.alibaba.fastjson.JSON;
import com.y4l3.platform.common.aop.annotation.Module;
import com.y4l3.platform.common.base.BaseService;
import com.y4l3.platform.module.sys.dao.PhonogramDao;
import com.y4l3.platform.module.sys.entity.*;
import com.y4l3.platform.module.sys.enumeration.PhonogramTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 音标app
 *
 * @author Kay
 * @version 1.0 2020/2/20
 */
@Service
@Module("音标")
public class PhonogramService extends BaseService<Phonogram, PhonogramDao> {

    private static final Logger logger = LoggerFactory.getLogger(PhonogramService.class);

    public Map<String, List<Phonogram>> getPhonetics() {
        List<Phonogram> phonetics = mapper.selectAll();
        Map<String, List<Phonogram>> phoneticsMap = new HashMap<>(4);
        Map<Boolean, List<Phonogram>> isVowels =
                phonetics.stream().collect(Collectors.groupingBy(phonogram -> PhonogramTypeEnum.isVowels(phonogram.getType())));
        phoneticsMap.put("vowels", isVowels.get(true));
        phoneticsMap.put("consonants", isVowels.get(false));
        logger.info("phoneticsMaps:{}", JSON.toJSONString(phoneticsMap));
        return phoneticsMap;
    }

}
