package io.github.jan.supabase.storage

import android.app.DownloadManager
import android.content.Context.DOWNLOAD_SERVICE
import androidx.core.net.toUri
import io.github.jan.supabase.annotiations.SupabaseInternal
import io.github.jan.supabase.auth.activity
import io.github.jan.supabase.auth.auth

@OptIn(SupabaseInternal::class)
fun BucketApi.downloadAuthenticatedWithManager(path: String, config: DownloadManager.Request.() -> Unit) {
    val request = DownloadManager.Request((this as BucketApiImpl).storage.resolveUrl("object/authenticated/$bucketId/$path").toUri())
        .apply(config)
        .addRequestHeader("Authorization", "Bearer ${storage.supabaseClient.auth.currentSession.value?.accessToken ?: throw IllegalStateException("Can't download from storage without a user session")}")
    val dm = storage.supabaseClient.auth.config.activity.getSystemService(DOWNLOAD_SERVICE) as DownloadManager
    dm.enqueue(request)
}

@OptIn(SupabaseInternal::class)
fun BucketApi.downloadPublicWithManager(path: String, config: DownloadManager.Request.() -> Unit) {
    val request = DownloadManager.Request((this as BucketApiImpl).storage.resolveUrl(publicUrl(path)).toUri())
        .apply(config)
    val dm = storage.supabaseClient.auth.config.activity.getSystemService(DOWNLOAD_SERVICE) as DownloadManager
    dm.enqueue(request)
}