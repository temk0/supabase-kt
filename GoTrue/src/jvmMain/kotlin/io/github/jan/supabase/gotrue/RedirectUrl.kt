package io.github.jan.supabase.gotrue

import io.github.jan.supabase.annotations.SupabaseInternal

@SupabaseInternal
actual fun GoTrue.generateRedirectUrl(fallbackUrl: String?): String? = fallbackUrl