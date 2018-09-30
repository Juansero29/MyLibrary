/*

 *This is free and unencumbered software released into the public domain.

 *

 *Anyone is free to copy, modify, publish, use, compile, sell, or

 *distribute this software, either in source code form or as a compiled

 *binary, for any purpose, commercial or non-commercial, and by any

 *means.

 *

 *In jurisdictions that recognize copyright laws, the author or authors

 *of this software dedicate any and all copyright interest in the

 *software to the public domain. We make this dedication for the benefit

 *of the public at large and to the detriment of our heirs and

 *successors. We intend this dedication to be an overt act of

 *relinquishment in perpetuity of all present and future rights to this

 *software under copyright law.

 *

 *THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,

 *EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF

 *MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.

 *IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR

 *OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,

 *ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR

 *OTHER DEALINGS IN THE SOFTWARE.

 *

 *For more information, please refer to <http://unlicense.org/>

 *

 */

package utils;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class is charged of generating long and short id's for other classes
 *
 * @author Juan
 */

public class IdGenerator {

    //region Static Fields

    /**
     * A long value that may be updated atomically. An AtomicLong is used in applications such as atomically
     * <p>
     * incremented sequence numbers, and cannot be used as a replacement for a Long. However, this class does
     * <p>
     * extend Number to allow uniform access by tools and utilities that deal with numerically-based classes
     */

    private static AtomicLong idCounter = new AtomicLong();

    //endregion

    //region Static Methods

    /**
     * Generates a string Id by using UUID.randomUUID.
     *
     * @return - The generated Id in the form of a string.
     */

    public static String generateStringId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Generates a long Id by using the AtomicLong class and calling the method 'getAndIncrement'. Hence, this
     * <p>
     * number will never be the same twice.
     *
     * @return - The Id in the form a long.
     * @see AtomicLong
     */

    public static long generateLongId() {

        return idCounter.getAndIncrement();

    }

    //endregion

}
