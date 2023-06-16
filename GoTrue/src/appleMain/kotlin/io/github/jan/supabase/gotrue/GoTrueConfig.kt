package io.github.jan.supabase.gotrue

import io.github.jan.supabase.plugins.MainConfig

/**
 * The configuration for [GoTrue]
 */
actual class GoTrueConfig : MainConfig, GoTrueConfigDefaults() {

    /**
     * The scheme for the redirect url, when using deep linking
     */
    var scheme: String = "supabase"

    /**
     * The host for the redirect url, when using deep linking
     */
    var host: String = "login"

}