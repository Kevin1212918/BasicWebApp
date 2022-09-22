package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("api:test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("api:Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("api:shakespeare"), containsString("playwright"));
    }
    
    @Test
    public void knowsAboutWhatIsYourName() throws Exception {
        assertThat(queryProcessor.process("api:what is your name"), containsString("Waffle"));
    }
    @Test
    public void knowsAboutAddition() throws Exception {
        assertThat(queryProcessor.process("api:what is 9 plus 10"), containsString("19"));
    }
    @Test
    public void knowsAboutMultiply() throws Exception {
        assertThat(queryProcessor.process("api:what is 9 multiplied by 10"), containsString("90"));
    }
    @Test
    public void knowsAboutBanana() throws Exception {
        assertThat(queryProcessor.process("api:what colour is banana"), containsString("yellow"));
    }

}
