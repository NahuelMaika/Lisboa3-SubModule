package ayds.lisboa3.submodule.lastFm.external

import retrofit2.Response

interface LastFmService {
    fun getArtistInfo(artistName: String): LastFmArtistInfo?
}

class LastFmServiceImpl(
    private val lastFMAPI: LastFmApi,
    private val lastFmToArtistInfoResolver: LastFmToArtistInfoResolver
): LastFmService {

    override fun getArtistInfo(artistName: String): LastFmArtistInfo? {
        val serviceData = getArtistInfoFromService(artistName)
        return lastFmToArtistInfoResolver.getArtistInfoFromExternalData(serviceData.body())
    }

    private fun getArtistInfoFromService(artistName: String): Response<String> {
        return lastFMAPI.getArtistInfo(artistName).execute()
    }
}