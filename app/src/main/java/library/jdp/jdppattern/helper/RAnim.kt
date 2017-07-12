package library.jdp.jdplib.helper

/**
 * Created by jamesdeperio on 7/9/2017.
 */
enum class RAnim constructor(anim: Byte) {
    SCALE_IN(0.toByte()),
    ALPHA_IN(1.toByte()),
    SLIDE_RIGHT(2.toByte()),
    SLIDE_LEFT(3.toByte()),
    SLIDE_BOTTOM(4.toByte());
    var anim: Byte = 0
    init {
        this.anim = anim
    }
}
