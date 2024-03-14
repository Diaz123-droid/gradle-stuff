package com.gradlestuff.builder;

import org.junit.jupiter.api.Test;

import com.gradlestuff.builder.Builder;

import java.io.IOException;

public class BuilderTest {
    @Test
    public void testBuilder() throws IOException{
        Builder.main(new String[]{"en"});
    }
}
