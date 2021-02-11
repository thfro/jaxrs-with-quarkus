package nrw.it.products.api;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativePersonsResourceIT extends PersonsResourceTest {

    // Execute the same tests but in native mode.
}