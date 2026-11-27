package com.metrolist.shared.auth

/**
 * Credential normalizers shared by the regular YouTube sign-in flows.
 * Kept separate from UI code so sign-in and playback are unaffected.
 * removing that screen does not affect OAuth login or playback.
 */

fun sanitizeDataSyncId(dataSyncId: String): String =
    dataSyncId
        .trim()
        .substringBefore("||")
        .ifBlank {
            dataSyncId.trim().substringAfter("||", "").trim()
        }

fun sanitizeAuthUser(authUser: String): String = authUser.filter { it.isDigit() }.ifBlank { "0" }

fun hasAuthCookie(cookie: String): Boolean = hasSupportedYouTubeAuthCookie(cookie)
