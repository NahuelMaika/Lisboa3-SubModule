package ayds.lisboa3.submodule.lastFm

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val LAST_FM_API_BASE_URL = "https://ws.audioscrobbler.com/2.0/"

object LastFmInjector {
    private lateinit var retrofit: Retrofit
    private lateinit var lastFmApi: LastFmApi
    private lateinit var lastFmToArtistInfoResolver: LastFmToArtistInfoResolver
    private lateinit var lastFmService: LastFmService

    fun getService(): LastFmService {
        initLastFmService()
        return lastFmService
    }

    private fun initLastFmService() {
        retrofit = getRetrofit()
        lastFmApi = getLastFmApi(retrofit)
        lastFmToArtistInfoResolver = LastFmToArtistInfoResolverImpl()
        lastFmService = LastFmServiceImpl(lastFmApi, lastFmToArtistInfoResolver)
    }

    private fun getRetrofit(): Retrofit {
        val retrofitBuilder = Retrofit.Builder()

        retrofitBuilder.baseUrl(LAST_FM_API_BASE_URL)
        retrofitBuilder.addConverterFactory(ScalarsConverterFactory.create())

        return retrofitBuilder.build()
    }

    private fun getLastFmApi(retrofit: Retrofit): LastFmApi {
        return retrofit.create(LastFmApi::class.java)
    }
}