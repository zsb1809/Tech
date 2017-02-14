package com.zhihua.tt.util;

import org.springframework.core.convert.converter.Converter;

public class StringToLong implements Converter<String, Long>{

	@Override
	public Long convert(String text) {
		if (text.isEmpty())
			return 0L;
		else
			return Long.parseLong(text);

	}

}
