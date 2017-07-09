package com.xiaopo.flying.photokit

import android.net.Uri

/**
 * @author wupanjie
 */
data class Photo(
    val id: Long,
    val uri: Uri = Uri.EMPTY,
    val mimeType: String = "",
    val size: Long = 0,
    val duration: Long = 0) {

}