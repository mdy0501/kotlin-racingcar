package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun isBlank() {
        assertThat("".isBlank()).isTrue()
        // Quiz
        assertThat(" ".isBlank()).isTrue()
        assertThat("\n".isBlank()).isTrue()
        assertThat("\t".isBlank()).isTrue()
        assertThat("""\n""".isBlank()).isFalse() // \와 n으로 이루어진 문자열이므로 공백으로 간주되지 않는다.
    }
}
