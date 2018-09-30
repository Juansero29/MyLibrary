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

package data;

import javafx.scene.image.Image;
import models.Author;
import models.Book;
import models.Magazine;
import models.Readable;

import java.time.LocalDate;

/**
 * This class contains stub data for products.
 *
 * @author Juan
 */
public class StubData {


    //region Static Methods
    public static Readable getStubReable() {
        return getStubBook();
    }

    public static Book getStubBook() {


        var image = new Image(Book.class.getResource("/images/stub/stub_cover.jpg").toString());

        return new Book("The Shining", getStubAuthor(),
                "The Shining is a horror novel by American author Stephen King. " +
                        "Published in 1977, it is King's third published novel and first " +
                        "hardback bestseller: the success of the book firmly established " +
                        "King as a preeminent author in the horror genre. The setting and " +
                        "characters are influenced by King's personal experiences, including " +
                        "both his visit to The Stanley Hotel in 1974 and his recovery from " +
                        "alcoholism. The novel was followed by a sequel, Doctor Sleep, published " +
                        "in 2013.", 2, 1977, 447, image);

    }

    public static Magazine getStubMagazine() {


        return new Magazine(
                "Playstation The Official Magazine Issue 64",
                new Author("Ben Wilson", LocalDate.of(1981, 6, 13)),
                "This magazine is cover dated December 2011 and priced at £5.99.",
                new Image(Book.class.getResource("/images/stub/stub_cover.jpg").toString()),
                64,
                132);
    }

    public static Author getStubAuthor() {
        return new Author("Stephen King", LocalDate.of(1947, 9, 21));
    }
    //endregion

}

