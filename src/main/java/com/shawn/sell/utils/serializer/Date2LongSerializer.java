package com.shawn.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * 数据库存的时间后面有000，所以传到前端需要转换
 * @Author: Shawn
 * @Date: 2019/3/19 17:31
 * @Version 1.0
 */
public class Date2LongSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
          gen.writeNumber( date.getTime() /1000);
    }
}
